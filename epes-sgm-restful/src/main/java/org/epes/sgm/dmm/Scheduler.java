package org.epes.sgm.dmm;

import java.util.ArrayList;

import org.epes.sgm.pojo.SchedulerInput;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.MutationOperator;
import org.jgap.impl.StockRandomGenerator;

import com.tecnalia.epes.tamoin.EPESChromosome;
import com.tecnalia.epes.tamoin.EPESGABreeder;
import com.tecnalia.epes.tamoin.MaintenanceFitnessFunction;
import com.tecnalia.epes.tamoin.MaintenanceTaskGene;
import com.tecnalia.epes.tamoin.MaintenanceThreeDaysTaskGene;
import com.tecnalia.epes.tamoin.MaintenanceTwoDaysTaskGene;
import com.tecnalia.epes.tamoin.WindFarm;
import com.tecnalia.epes.tamoin.util.GATask;
import com.tecnalia.epes.tamoin.util.XLSReader;
import com.tecnalia.epes.tamoin.util.XLSTask;
import com.tecnalia.epes.tamoin.util.XLSTasksAdaptor;
import com.tecnalia.epes.tamoin.wunderground.utils.WundergroundUtils;

public class Scheduler {
	public static void schedule(SchedulerInput input) {
		System.out.println("Optimization Service remotely launched!");
		
		// Set general parameters
		boolean readXlsFromVCN = Boolean.valueOf(input.getGeneralParameters().get(0).get("readXlsFromVCN"));
		boolean saveGanttChartToVCN = Boolean.valueOf(input.getGeneralParameters().get(1).get("saveGanttChartToVCN"));
		
		// Set weather forecast parameters. Set to true if the forecast will be retrieved from a weather service
		boolean calculateWeatherForecast = Boolean.valueOf(input.getForecastParameters().get(0).get("calculateWeatherForecast"));
		// wind farm one user defined wind forecast (m/s)
		int windFarmOneWindSpeedMonday = Integer.parseInt(input.getForecastParameters().get(1).get("windFarmOneWindSpeedMonday"));
		int windFarmOneWindSpeedTuesday = Integer.parseInt(input.getForecastParameters().get(2).get("windFarmOneWindSpeedTuesday"));
		int windFarmOneWindSpeedWednesday = Integer.parseInt(input.getForecastParameters().get(3).get("windFarmOneWindSpeedWednesday"));
		int windFarmOneWindSpeedThursday = Integer.parseInt(input.getForecastParameters().get(4).get("windFarmOneWindSpeedThursday"));
		int windFarmOneWindSpeedFriday = Integer.parseInt(input.getForecastParameters().get(5).get("windFarmOneWindSpeedFriday"));
		// wind farm two user defined wind forecast (m/s)
		int windFarmTwoWindSpeedMonday = Integer.parseInt(input.getForecastParameters().get(6).get("windFarmTwoWindSpeedMonday"));
		int windFarmTwoWindSpeedTuesday = Integer.parseInt(input.getForecastParameters().get(7).get("windFarmTwoWindSpeedTuesday"));
		int windFarmTwoWindSpeedWednesday = Integer.parseInt(input.getForecastParameters().get(8).get("windFarmTwoWindSpeedWednesday"));
		int windFarmTwoWindSpeedThursday = Integer.parseInt(input.getForecastParameters().get(9).get("windFarmTwoWindSpeedThursday"));
		int windFarmTwoWindSpeedFriday = Integer.parseInt(input.getForecastParameters().get(10).get("windFarmTwoWindSpeedFriday"));
		// wind farm three user defined wind forecast (m/s)
		int windFarmThreeWindSpeedMonday = Integer.parseInt(input.getForecastParameters().get(11).get("windFarmThreeWindSpeedMonday"));
		int windFarmThreeWindSpeedTuesday = Integer.parseInt(input.getForecastParameters().get(12).get("windFarmThreeWindSpeedTuesday"));
		int windFarmThreeWindSpeedWednesday = Integer.parseInt(input.getForecastParameters().get(13).get("windFarmThreeWindSpeedWednesday"));
		int windFarmThreeWindSpeedThursday = Integer.parseInt(input.getForecastParameters().get(14).get("windFarmThreeWindSpeedThursday"));
		int windFarmThreeWindSpeedFriday = Integer.parseInt(input.getForecastParameters().get(15).get("windFarmThreeWindSpeedFriday"));
		
		// Set optimization perspective
		// If the next both two parameters are set to true or false, the default optimization perspective is used as a combination of costs
		// optimization and availability optimization
		boolean optimizeCosts = Boolean.valueOf(input.getOptimizationPerspectiveParameters().get(0).get("optimizeCosts"));
		boolean optimizeAvailability = Boolean.valueOf(input.getOptimizationPerspectiveParameters().get(1).get("optimizeAvailability"));
		
		// Retrieve wind farm information about forecasted winds
		int[][] windSpeeds = new int[][] {{windFarmOneWindSpeedMonday, windFarmOneWindSpeedTuesday, windFarmOneWindSpeedWednesday, windFarmOneWindSpeedThursday, windFarmOneWindSpeedFriday},
				{windFarmTwoWindSpeedMonday, windFarmTwoWindSpeedTuesday, windFarmTwoWindSpeedWednesday, windFarmTwoWindSpeedThursday, windFarmTwoWindSpeedFriday},
				{windFarmThreeWindSpeedMonday, windFarmThreeWindSpeedTuesday, windFarmThreeWindSpeedWednesday, windFarmThreeWindSpeedThursday, windFarmThreeWindSpeedFriday}};		
		WindFarm[] windFarms = WundergroundUtils.calculateWindFarms(calculateWeatherForecast, windSpeeds);
		
        // JGAP
		
		Configuration config = new DefaultConfiguration();
		
		String weekNumber = input.getWeekNumber(); // 01 (162), 08 (888), 03 (396)
		
		ArrayList<XLSTask> xlsTasksArrayList = XLSReader.readXLSTasks(weekNumber, readXlsFromVCN);
		
		XLSTasksAdaptor xLSTaskAdaptor = new XLSTasksAdaptor(xlsTasksArrayList);
		
		ArrayList<GATask> gATasksArrayList = xLSTaskAdaptor.getGaTasks();
		
		int sampleGenesSize = gATasksArrayList.size();
		
		Gene[] sampleGenes = new Gene[sampleGenesSize];
		
		Genotype population = null;		
		try {
			for (int i = 0; i < sampleGenesSize; i++) {		
				if (gATasksArrayList.get(i).getName().equals("GC GENERADOR")
						|| gATasksArrayList.get(i).getName().equals("GC MULTI")) {
					sampleGenes[i] = new MaintenanceTwoDaysTaskGene(config, gATasksArrayList.get(i).getDuration(), 
							gATasksArrayList.get(i).getDurationSecondDay(), 
							gATasksArrayList.get(i).getWindFarm(), gATasksArrayList.get(i).getWindTurbine(), 
							gATasksArrayList.get(i).getMaintenanceTeams());
					sampleGenes[i].setToRandomValue(new StockRandomGenerator());
				   	((MaintenanceTaskGene) sampleGenes[i]).setName(gATasksArrayList.get(i).getName());
				   	((MaintenanceTaskGene) sampleGenes[i]).setPriority(gATasksArrayList.get(i).getPriority());
				   	((MaintenanceTaskGene) sampleGenes[i]).setMaintenanceTeamNames(gATasksArrayList.get(i).getMaintenanceTeamNames());	   
				   	((MaintenanceTaskGene) sampleGenes[i]).setWindSpeedLimit(gATasksArrayList.get(i).getWindSpeedLimit());				   	
				} else if (gATasksArrayList.get(i).getName().equals("GC ROTOR")) {
					sampleGenes[i] = new MaintenanceThreeDaysTaskGene(config, gATasksArrayList.get(i).getDuration(), 
							gATasksArrayList.get(i).getDurationSecondDay(), gATasksArrayList.get(i).getDurationThirdDay(),
							gATasksArrayList.get(i).getWindFarm(), gATasksArrayList.get(i).getWindTurbine(), 
							gATasksArrayList.get(i).getMaintenanceTeams());
					sampleGenes[i].setToRandomValue(new StockRandomGenerator());
				   	((MaintenanceTaskGene) sampleGenes[i]).setName(gATasksArrayList.get(i).getName());
				   	((MaintenanceTaskGene) sampleGenes[i]).setPriority(gATasksArrayList.get(i).getPriority());
				   	((MaintenanceTaskGene) sampleGenes[i]).setMaintenanceTeamNames(gATasksArrayList.get(i).getMaintenanceTeamNames());	   
				   	((MaintenanceTaskGene) sampleGenes[i]).setWindSpeedLimit(gATasksArrayList.get(i).getWindSpeedLimit());						
				} else {
					sampleGenes[i] = new MaintenanceTaskGene(config, gATasksArrayList.get(i).getDuration(),
							gATasksArrayList.get(i).getWindFarm(), gATasksArrayList.get(i).getWindTurbine(), 
							gATasksArrayList.get(i).getMaintenanceTeams());
					sampleGenes[i].setToRandomValue(new StockRandomGenerator());
				   	((MaintenanceTaskGene) sampleGenes[i]).setName(gATasksArrayList.get(i).getName());
				   	((MaintenanceTaskGene) sampleGenes[i]).setPriority(gATasksArrayList.get(i).getPriority());
				   	((MaintenanceTaskGene) sampleGenes[i]).setMaintenanceTeamNames(gATasksArrayList.get(i).getMaintenanceTeamNames());	   
				   	((MaintenanceTaskGene) sampleGenes[i]).setWindSpeedLimit(gATasksArrayList.get(i).getWindSpeedLimit());
				}	 
			}
			   	IChromosome sampleChromosome = new EPESChromosome(config, sampleGenes);
					
			   	System.out.println("SampleChromosome: " + sampleChromosome);
			    	
			   	config.setSampleChromosome(sampleChromosome);
			   	config.setPopulationSize(1000); // 100
			   	config.setPreservFittestIndividual(true);
			    config.setKeepPopulationSizeConstant(false);	    
			    config.setFitnessFunction(new MaintenanceFitnessFunction(windFarms[0], windFarms[1], windFarms[2], optimizeCosts, optimizeAvailability));
			    config.setBreeder(new EPESGABreeder());
				config.getGeneticOperators().clear();
				config.addGeneticOperator(new CrossoverOperator(config, 0.70d));
				config.addGeneticOperator(new MutationOperator(config, 1000));
				population = Genotype.randomInitialGenotype(config);		    	
			} catch (InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		// population.evolve();
		
		// System.out.println(population);
		
		for (int i = 0; i < 50*4/4; i++) { //500
			population.evolve();
		}	
		
		//population.evolve();
		
		IChromosome bestSolutionSoFar = population.getFittestChromosome();
	    double v1 = bestSolutionSoFar.getFitnessValue();
		
	    //System.out.println(population);
	    
	    System.out.println("BS: " + bestSolutionSoFar);
	    System.out.println("BS Fitness value: " + v1);	    
	    
	    com.tecnalia.epes.tamoin.ganttchart.TamoinGanttChart.createGanttChart(bestSolutionSoFar, saveGanttChartToVCN);
	}

}
