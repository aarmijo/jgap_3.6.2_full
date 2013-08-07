/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package com.tecnalia.epes.tamoin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.jgap.*;
import org.jgap.impl.*;

import com.tecnalia.epes.tamoin.util.GATask;
import com.tecnalia.epes.tamoin.util.XLSReader;
import com.tecnalia.epes.tamoin.util.XLSTask;
import com.tecnalia.epes.tamoin.util.XLSTasksAdaptor;
import com.tecnalia.epes.tamoin.wunderground.connector.WunderException;
import com.tecnalia.epes.tamoin.wunderground.connector.WundergroundConnector;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.ForecastDayExtended;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.Wind;
import com.tecnalia.epes.tamoin.wunderground.htmlgenerator.WundergroundHtmlGenerator;
import com.tecnalia.epes.tamoin.wunderground.utils.WundergroundUtils;

import junit.framework.*;

/**
 * Tests the FixedBinaryGene class.
 *
 * @author Klaus Meffert
 * @author vamsi
 * @since 2.0
 */
public class MaintenanceTaskGeneTest
    extends JGAPTestCase {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.34 $";

  public static Test suite() {
    TestSuite suite = new TestSuite(MaintenanceTaskGeneTest.class);
    return suite;
  }
  
	public void setUp() {
		super.setUp();
		Configuration.reset();
	}

  /**
   *
   * @author Klaus Meffert
   * @since 2.2
   * @throws Exception
   */
/*
  public void testSetToRandomValue_0()
      throws Exception {
    FixedBinaryGene gene1 = new FixedBinaryGene(conf, 7);
    try {
      gene1.setToRandomValue(null);
      fail();
    }
    catch (IllegalArgumentException iex) {
      ; //this is OK
    }
  }
*/
  /**
   * @throws Exception
   *
   * @author Klaus Meffert
   * @since 2.2
   */

/*  
   public void testSetToRandomValue_1() throws Exception {
		Unit1Gene gene1 = new Unit1Gene(conf, 6);
		gene1.setToRandomValue(new StockRandomGenerator());
		System.out.println(gene1);
	}
	
	public void testSetToRandomValue_2() throws Exception {
		Unit2Gene gene2 = new Unit2Gene(conf, 6);
		gene2.setToRandomValue(new StockRandomGenerator());
		System.out.println(gene2);
	}

	public void testSetToRandomValue_3() throws Exception {
		Unit3Gene gene3 = new Unit3Gene(conf, 6);
		gene3.setToRandomValue(new StockRandomGenerator());
		System.out.println(gene3);
	}
	
	public void testSetToRandomValue_4() throws Exception {
		Unit4Gene gene4 = new Unit4Gene(conf, 6);
		gene4.setToRandomValue(new StockRandomGenerator());
		System.out.println(gene4);
	}
*/	/*
	public void testConstruct_1() throws Exception {
		Configuration config = new DefaultConfiguration();
		Gene[] sampleGenes = new Gene[9];

    	// task 1 WF1
    	sampleGenes[0] =  new MaintenanceTaskGene(config, 7, 1, 42, 1);    	
    	//sampleGenes[0].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[0]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[0]).setBit(1, false);
        ((MaintenanceTaskGene) sampleGenes[0]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[0]).setBit(3, true);
        ((MaintenanceTaskGene) sampleGenes[0]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[0]).setName("PENDIENTE PREVENTIVO");
    	((MaintenanceTaskGene) sampleGenes[0]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[0]).setMaintenanceTeamNames("C1");   	
    	
    	// task 2 WF1
    	sampleGenes[1] = new MaintenanceTaskGene(config, 7, 1, 35, 1);
    	//sampleGenes[1].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[1]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[1]).setBit(1, true);
        ((MaintenanceTaskGene) sampleGenes[1]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[1]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[1]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[1]).setName("PENDIENTE PREVENTIVO");
    	((MaintenanceTaskGene) sampleGenes[1]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[1]).setMaintenanceTeamNames("C1");
    	
        // task 3 WF1
    	sampleGenes[2] = new MaintenanceTaskGene(config, 7, 1, 24, 1);
    	//sampleGenes[2].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[2]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[2]).setBit(1, true);
        ((MaintenanceTaskGene) sampleGenes[2]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[2]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[2]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[2]).setName("PENDIENTE PREVENTIVO");
    	((MaintenanceTaskGene) sampleGenes[2]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[2]).setMaintenanceTeamNames("C1");
    	
    	// task 4 WF2
    	sampleGenes[3] = new MaintenanceTaskGene(config, 7, 2, 8, 1);
    	//sampleGenes[3].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[3]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[3]).setBit(1, true);
        ((MaintenanceTaskGene) sampleGenes[3]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[3]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[3]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[3]).setName("PREVENTIVO 6M");
    	((MaintenanceTaskGene) sampleGenes[3]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[3]).setMaintenanceTeamNames("C2");
    	
    	// task 5 WF2
    	sampleGenes[4] = new MaintenanceTaskGene(config, 7, 2, 11, 1);
    	//sampleGenes[4].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[4]).setBit(0, true);
        ((MaintenanceTaskGene) sampleGenes[4]).setBit(1, false);
        ((MaintenanceTaskGene) sampleGenes[4]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[4]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[4]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[4]).setName("PREVENTIVO 6M");
    	((MaintenanceTaskGene) sampleGenes[4]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[4]).setMaintenanceTeamNames("C5");
    	
    	// task 6 WF2
    	sampleGenes[5] = new MaintenanceTaskGene(config, 7, 2, 35, 1);
    	//sampleGenes[5].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[5]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[5]).setBit(1, false);
        ((MaintenanceTaskGene) sampleGenes[5]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[5]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[5]).setBit(4, true);
    	((MaintenanceTaskGene) sampleGenes[5]).setName("PREVENTIVO 6M");
    	((MaintenanceTaskGene) sampleGenes[5]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[5]).setMaintenanceTeamNames("C2");
    	
    	// task 7 WF3
    	sampleGenes[6] = new MaintenanceTaskGene(config, 0, 3, 24, 1);
    	//sampleGenes[6].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[6]).setBit(0, true);
        ((MaintenanceTaskGene) sampleGenes[6]).setBit(1, false);
        ((MaintenanceTaskGene) sampleGenes[6]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[6]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[6]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[6]).setName("ACCION CORRECTORA ANALITICA");
    	((MaintenanceTaskGene) sampleGenes[6]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[6]).setMaintenanceTeamNames("C6");
    	
    	// task 8 WF3
    	sampleGenes[7] = new MaintenanceTaskGene(config, 1, 3, 7, 1);
    	//sampleGenes[7].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[7]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[7]).setBit(1, true);
        ((MaintenanceTaskGene) sampleGenes[7]).setBit(2, false); 
        ((MaintenanceTaskGene) sampleGenes[7]).setBit(3, false);
        ((MaintenanceTaskGene) sampleGenes[7]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[7]).setName("COMP. ALINEADO");
    	((MaintenanceTaskGene) sampleGenes[7]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[7]).setMaintenanceTeamNames("C3");
    	
    	// task 9 WF3
    	sampleGenes[8] = new MaintenanceTaskGene(config, 1, 3, 47, 1);
    	//sampleGenes[8].setToRandomValue(new StockRandomGenerator());
        ((MaintenanceTaskGene) sampleGenes[8]).setBit(0, false);
        ((MaintenanceTaskGene) sampleGenes[8]).setBit(1, false);
        ((MaintenanceTaskGene) sampleGenes[8]).setBit(2, false);
        ((MaintenanceTaskGene) sampleGenes[8]).setBit(3, true);
        ((MaintenanceTaskGene) sampleGenes[8]).setBit(4, false);
    	((MaintenanceTaskGene) sampleGenes[8]).setName("COMP. ALINEADO");
    	((MaintenanceTaskGene) sampleGenes[8]).setPriority(1);
    	((MaintenanceTaskGene) sampleGenes[8]).setMaintenanceTeamNames("C3");

    	IChromosome sampleChromosome = new EPESChromosome(config, sampleGenes);
		
    	config.setSampleChromosome(sampleChromosome);
    	config.setPopulationSize(100); // 100
    	config.setPreservFittestIndividual(true);
	    config.setKeepPopulationSizeConstant(false);
	    config.setFitnessFunction(new MaintenanceFitnessFunction());
	    config.setBreeder(new EPESGABreeder());
		config.getGeneticOperators().clear();
		config.addGeneticOperator(new CrossoverOperator(config, 0.70d));
	    config.addGeneticOperator(new MutationOperator(config, 1000));
		Genotype population = Genotype.randomInitialGenotype(config);
		
		//System.out.println(population);
		
		for (int i = 0; i < 50; i++) { //500
			population.evolve();
		}	
		
		//population.evolve();
		
		IChromosome bestSolutionSoFar = population.getFittestChromosome();
	    double v1 = bestSolutionSoFar.getFitnessValue();
		
	    //System.out.println(population);
	    
	    System.out.println("BS: " + bestSolutionSoFar);
	    System.out.println("BS Fitness value: " + v1);	    
	    
	    TamoinGanttChart.createGanttChart(bestSolutionSoFar);
	}*/
	
	public void testConstruct_2() {
		
		// Set optimization parameters
		boolean calculateWeatherForecast = false;
		
		// Set the wind farm wind conditions
		WindFarm windFarmOne = null;
		WindFarm windFarmTwo = null;
		WindFarm windFarmThree = null;		
		
		if (calculateWeatherForecast) {
			try {
				Properties prop;
				prop = WundergroundUtils.load("windFarmOne.config.properties");
		        WundergroundConnector wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        List<ForecastDayExtended> forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday();        
		        //int nextMondayIndex = WundergroundUtils.getNextMondayIndex(forecastDayArrayList);
		        int[] windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);

				// Wind farm one forecasted wind speed
		        windFarmOne = new WindFarm(1, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
		        
		        prop.clear();
		        prop = WundergroundUtils.load("windFarmTwo.config.properties");
		        wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday(); 
		        windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);
		        
		        // Wind farm two forecasted wind speed
		        windFarmTwo = new WindFarm(2, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
		        
		        prop.clear();
		        prop = WundergroundUtils.load("windFarmThree.config.properties");
		        wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday(); 
		        windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);
		        
		        // Wind farm three forecasted wind speed
		        windFarmThree = new WindFarm(3, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
			} catch (Exception e) {
				// If there is any problem with the forecast set the windspeeds to 10 m/s
				e.printStackTrace();
				windFarmOne = new WindFarm(1, 10, 10, 10, 
		        		10, 10);
				windFarmTwo = new WindFarm(2, 10, 10, 10, 
		        		10, 10);
				windFarmThree = new WindFarm(3, 10, 10, 10, 
		        		10, 10);
			}
		} else {
			// Set the windspeeds to 10 m/s or user selected values
			windFarmOne = new WindFarm(1, 10, 10, 10, 
	        		10, 10);
			windFarmTwo = new WindFarm(2, 10, 10, 10, 
	        		10, 10);
			windFarmThree = new WindFarm(3, 10, 10, 10, 
	        		10, 10);
		}
        
        // JGAP
        
		Configuration config = new DefaultConfiguration();
		
		String weekNumber = "08"; // 01 (162), 08 (888), 03 (396)
		
		ArrayList<XLSTask> xlsTasksArrayList = XLSReader.readXLSTasks(weekNumber);
		
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
			    config.setFitnessFunction(new MaintenanceFitnessFunction(windFarmOne, windFarmTwo, windFarmThree));
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
		
		for (int i = 0; i < 50*4; i++) { //500
			population.evolve();
		}	
		
		//population.evolve();
		
		IChromosome bestSolutionSoFar = population.getFittestChromosome();
	    double v1 = bestSolutionSoFar.getFitnessValue();
		
	    //System.out.println(population);
	    
	    System.out.println("BS: " + bestSolutionSoFar);
	    System.out.println("BS Fitness value: " + v1);	    
	    
	    TamoinGanttChart.createGanttChart(bestSolutionSoFar);
	}
	
  /**
   *
   * @author Klaus Meffert
   * @since 2.2
   * @throws Exception
   */
/* 
  public void testSetToRandomValue_2()
      throws Exception {
    FixedBinaryGene gene1 = new FixedBinaryGene(conf, 7);
    gene1.setToRandomValue(new RandomGeneratorForTesting(false));
    for (int i = 0; i < 7; i++) {
      assertFalse(gene1.getBit(i));
    }
  }
*/
  /**
   *
   * @author Klaus Meffert
   * @since 2.2
   * @throws Exception
   */
/*
  public void testSetToRandomValue_3()
      throws Exception {
    FixedBinaryGene gene1 = new FixedBinaryGene(conf, 7);
    gene1.setToRandomValue(new RandomGeneratorForTesting(true));
    for (int i = 0; i < 7; i++) {
      assertTrue(gene1.getBit(i));
    }
  }
*/
}
