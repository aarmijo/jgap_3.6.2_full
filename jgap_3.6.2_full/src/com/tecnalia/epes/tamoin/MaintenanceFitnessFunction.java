package com.tecnalia.epes.tamoin;

import java.util.*;

import org.jgap.*;
import org.jgap.gp.function.RandomGenerator;
import org.jgap.impl.*;

import com.tecnalia.epes.tamoin.wunderground.htmlgenerator.WundergroundHtmlGenerator;
import com.tecnalia.epes.tamoin.wunderground.utils.WundergroundUtils;

@SuppressWarnings("serial")
public class MaintenanceFitnessFunction extends FitnessFunction {

	public MaintenanceFitnessFunction(WindFarm windFarmOne,
			WindFarm windFarmTwo, WindFarm windFarmThree) {
		super();
		this.windFarmOne = windFarmOne;
		this.windFarmTwo = windFarmTwo;
		this.windFarmThree = windFarmThree;
		
		this.weatherPriorityWindFarmOneArray = windFarmOne.calculateWeatherPriorityArray();
		this.weatherPriorityWindFarmTwoArray = windFarmTwo.calculateWeatherPriorityArray();
		this.weatherPriorityWindFarmThreeArray = windFarmThree.calculateWeatherPriorityArray();
	}

	private WindFarm windFarmOne;
	private WindFarm windFarmTwo;
	private WindFarm windFarmThree;
	
	private int[] weatherPriorityWindFarmOneArray;
	private int[] weatherPriorityWindFarmTwoArray;
	private int[] weatherPriorityWindFarmThreeArray;
	
    public WindFarm getWindFarmOne() {
		return windFarmOne;
	}

	public void setWindFarmOne(WindFarm windFarmOne) {
		this.windFarmOne = windFarmOne;
	}

	public WindFarm getWindFarmTwo() {
		return windFarmTwo;
	}

	public void setWindFarmTwo(WindFarm windFarmTwo) {
		this.windFarmTwo = windFarmTwo;
	}

	public WindFarm getWindFarmThree() {
		return windFarmThree;
	}

	public void setWindFarmThree(WindFarm windFarmThree) {
		this.windFarmThree = windFarmThree;
	}
	
	public int[] getWeatherPriorityWindFarmOneArray() {
		return weatherPriorityWindFarmOneArray;
	}

	public void setWeatherPriorityWindFarmOneArray(
			int[] weatherPriorityWindFarmOneArray) {
		this.weatherPriorityWindFarmOneArray = weatherPriorityWindFarmOneArray;
	}

	public int[] getWeatherPriorityWindFarmTwoArray() {
		return weatherPriorityWindFarmTwoArray;
	}

	public void setWeatherPriorityWindFarmTwoArray(
			int[] weatherPriorityWindFarmTwoArray) {
		this.weatherPriorityWindFarmTwoArray = weatherPriorityWindFarmTwoArray;
	}

	public int[] getWeatherPriorityWindFarmThreeArray() {
		return weatherPriorityWindFarmThreeArray;
	}

	public void setWeatherPriorityWindFarmThreeArray(
			int[] weatherPriorityWindFarmThreeArray) {
		this.weatherPriorityWindFarmThreeArray = weatherPriorityWindFarmThreeArray;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InvalidConfigurationException {
    	
    	/*// Maintenance tasks array
    	MaintenanceTaskGene[] maintenanceTaskGeneArray = new MaintenanceTaskGene[9];

    	// WindFarm 1
    	maintenanceTaskGeneArray[0] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 1, 42, 1);
    	maintenanceTaskGeneArray[0].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[0].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[1] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 1, 35, 1);
    	maintenanceTaskGeneArray[1].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[1].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[2] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 1, 24, 1);
    	maintenanceTaskGeneArray[2].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[2].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[3] = new MaintenanceTaskGene(new DefaultConfiguration(), 0, 1, 24, 1);
    	maintenanceTaskGeneArray[3].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[3].setName("PREVENTIVO OTROS");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[4] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 49, 1);
    	maintenanceTaskGeneArray[4].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[4].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[5] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 1, 49, 1);
    	maintenanceTaskGeneArray[5].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[5].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[6] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 48, 1);
    	maintenanceTaskGeneArray[6].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[6].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[7] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 47, 1);
    	maintenanceTaskGeneArray[7].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[7].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[8] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 47, 1);
    	maintenanceTaskGeneArray[8].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[8].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[9] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 20, 1);
    	maintenanceTaskGeneArray[9].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[9].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[10] = new MaintenanceTaskGene(new DefaultConfiguration(), 2, 1, 46, 1);
    	maintenanceTaskGeneArray[10].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[10].setName("CAMBIO ACEITE REDUCTORAS YAW");
    	
    	Configuration.reset();
    	    	
    	// WindFarm 2
    	maintenanceTaskGeneArray[3] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 8, 1);
    	maintenanceTaskGeneArray[3].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[3].setName("PREVENTIVO 6M");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[4] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 11, 1);
    	maintenanceTaskGeneArray[4].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[4].setName("PREVENTIVO 6M");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[5] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 35, 1);
    	maintenanceTaskGeneArray[5].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[5].setName("PREVENTIVO 6M");

    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[14] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 62, 1);
    	maintenanceTaskGeneArray[14].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[14].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[15] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 60, 1);
    	maintenanceTaskGeneArray[15].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[15].setName("PENDIENTE PREVENTIVO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[16] = new MaintenanceTaskGene(new DefaultConfiguration(), 7, 2, 36, 1);
    	maintenanceTaskGeneArray[16].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[16].setName("PREVENTIVO 6M");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[17] = new MaintenanceTaskGene(new DefaultConfiguration(), 0, 2, 64, 1);
    	maintenanceTaskGeneArray[17].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[17].setName("PREVENTIVO OTROS");
    	
    	Configuration.reset();
    	
    	// windfarm 3
    	
    	maintenanceTaskGeneArray[6] = new MaintenanceTaskGene(new DefaultConfiguration(), 0, 3, 24, 1);
    	maintenanceTaskGeneArray[6].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[6].setName("ACCION CORRECTORA ANALITICA");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[7] = new MaintenanceTaskGene(new DefaultConfiguration(), 1, 3, 7, 1);
    	maintenanceTaskGeneArray[7].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[7].setName("COMP. ALINEADO");
    	
    	Configuration.reset();
    	
    	maintenanceTaskGeneArray[8] = new MaintenanceTaskGene(new DefaultConfiguration(), 1, 3, 47, 1);
    	maintenanceTaskGeneArray[8].setToRandomValue(new StockRandomGenerator());
    	maintenanceTaskGeneArray[8].setName("COMP. ALINEADO");
    	
    	// Maintenance tasks arrays sorted by windfarm
    	ArrayList<MaintenanceTaskGene> maintenanceTaskArrayListWindFarmOne = new ArrayList<MaintenanceTaskGene>();
    	ArrayList<MaintenanceTaskGene> maintenanceTaskArrayListWindFarmTwo = new ArrayList<MaintenanceTaskGene>();
    	ArrayList<MaintenanceTaskGene> maintenanceTaskArrayListWindFarmThree = new ArrayList<MaintenanceTaskGene>();
    	
    	for (int i = 0; i < maintenanceTaskGeneArray.length;i++){
    		if (maintenanceTaskGeneArray[i].getWindFarm() == 1) {
    			maintenanceTaskArrayListWindFarmOne.add(maintenanceTaskGeneArray[i]);
    		} else if (maintenanceTaskGeneArray[i].getWindFarm() == 2) {
    			maintenanceTaskArrayListWindFarmTwo.add(maintenanceTaskGeneArray[i]);
    		} else {
    			maintenanceTaskArrayListWindFarmThree.add(maintenanceTaskGeneArray[i]);
    		}
    	}
    	
    	// parques
    	// params: windfarm, windspeeds
    	WindFarm windFarm1 = new WindFarm(1, 10, 0, 0, 0, 0);
    	WindFarm windFarm2 = new WindFarm(2, 10, 0, 0, 0, 0);
    	WindFarm windFarm3 = new WindFarm(3, 10, 0, 0, 0, 0);
    	
    	for (int i = 0; i < maintenanceTaskGeneArray.length; i++) {
    		System.out.println(maintenanceTaskGeneArray[i]);
    	}    
    	    
    	System.out.println("----------------------------- Genes WF1 -----------------------------");
    	for (MaintenanceTaskGene mtg : maintenanceTaskArrayListWindFarmOne) {
    		System.out.println(mtg.toString());
    	}
    	
    	System.out.println("----------------------------- Genes WF2 -----------------------------");
    	for (MaintenanceTaskGene mtg : maintenanceTaskArrayListWindFarmTwo) {
    		System.out.println(mtg.toString());
    	}
    	
    	System.out.println("----------------------------- Genes WF3 -----------------------------");
    	for (MaintenanceTaskGene mtg : maintenanceTaskArrayListWindFarmThree) {
    		System.out.println(mtg.toString());
    	}*/

    	
    	// evaluar cromosoma
    	
    	Gene[] sampleGenes = new Gene[9];
    	
    	Configuration.reset();
    	
    	Configuration config = new DefaultConfiguration();
    	
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

    	IChromosome sampleChromosome = new Chromosome(config, sampleGenes);
        
        System.out.println(sampleChromosome);
    	
    	//System.out.println("gene->" + sampleGenes[0].toString());
    	
        //System.out.println(new MaintenanceFitnessFunction().evaluate(sampleChromosome));  	
    }
    
	@SuppressWarnings("unused")
	@Override
	protected double evaluate(IChromosome a_subject) {		
		int genesNumber = a_subject.size();
		Gene genes[] = a_subject.getGenes();
		int geneLength = ((MaintenanceTaskGene)genes[0]).getLength();
		
		ArrayList<MaintenanceTaskGene> windFarmAllMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		int windFarmAllMaintenanceTasks[][] = new int[genesNumber][geneLength];
		for (int i = 0; i < genesNumber; i++) {		
			windFarmAllMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			for (int j = 0; j < geneLength; j++) {
				windFarmAllMaintenanceTasks[i][j] = ((MaintenanceTaskGene)genes[i]).getBit(j)? 1 : 0;
			}
		}
		
		ArrayList<MaintenanceTaskGene> windFarmOneMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		ArrayList<MaintenanceTaskGene> windFarmTwoMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		ArrayList<MaintenanceTaskGene> windFarmThreeMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		for (int i = 0; i < genes.length ; i++) {
			if (((MaintenanceTaskGene) genes[i]).getWindFarm() == 1) {
				windFarmOneMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			} else if (((MaintenanceTaskGene) genes[i]).getWindFarm() == 2) {
				windFarmTwoMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			} else {
				windFarmThreeMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			}
		}
		
		int windFarmOneMaintenanceTasks[][] = new int[windFarmOneMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmOneMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmOneMaintenanceTasks[i][j] = windFarmOneMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		int windFarmTwoMaintenanceTasks[][] = new int[windFarmTwoMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmTwoMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmTwoMaintenanceTasks[i][j] = windFarmTwoMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		int windFarmThreeMaintenanceTasks[][] = new int[windFarmThreeMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmThreeMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmThreeMaintenanceTasks[i][j] = windFarmThreeMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		// Human resources constraints (number of maintenance teams and working hours)
		// wind farm 1	
		int[] windFarmOneMaintenanceTeamsNumberArray = new int[geneLength];
		int[][] windFarmOneMaintenanceTeamsInvolvedArray = new int[][] {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
		MaintenanceTeamsCounter mTCWF1 = new MaintenanceTeamsCounter();
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmOneMaintenanceTasks.length; i++) {
				if (windFarmOneMaintenanceTasks[i][j] == 1) {				
					String maintenanceTeamName = windFarmOneMaintenanceTasksArrayList
							.get(i).getMaintenanceTeamNames();
					switch (maintenanceTeamName) {
					case "C1":
						mTCWF1.setC1(true);
						mTCWF1.setC1Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C2":
						mTCWF1.setC2(true);
						mTCWF1.setC2Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C3":
						mTCWF1.setC3(true);
						mTCWF1.setC3Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C4":
						mTCWF1.setC4(true);
						mTCWF1.setC4Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C5":
						mTCWF1.setC5(true);
						mTCWF1.setC5Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C6":
						mTCWF1.setC6(true);
						mTCWF1.setC6Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C7":
						mTCWF1.setC7(true);
						mTCWF1.setC7Hours(windFarmOneMaintenanceTasksArrayList.get(i).getDuration());
						break;
					}					
				}					
			}
			int numberOfTeams = 0;			
			if (mTCWF1.isC1()) {
				// check that the working hours for a maintenance team is lower that 7 for each day j
				if (mTCWF1.getC1Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				// Set the teams involved on each day j
				windFarmOneMaintenanceTeamsInvolvedArray[j][0] = 1;
			}
			if (mTCWF1.isC2()) {
				if (mTCWF1.getC2Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][1] = 1;
			}			
			if (mTCWF1.isC3()) {
				if (mTCWF1.getC3Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][2] = 1;
			}
			if (mTCWF1.isC4()) {
				if (mTCWF1.getC4Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][3] = 1;
			}
			if (mTCWF1.isC5()) {
				if (mTCWF1.getC5Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][4] = 1;
			}
			if (mTCWF1.isC6()) {
				if (mTCWF1.getC6Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][5] = 1;
			}
			if (mTCWF1.isC7()) {
				if (mTCWF1.getC7Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmOneMaintenanceTeamsInvolvedArray[j][6] = 1;
			}			
			windFarmOneMaintenanceTeamsNumberArray[j] = numberOfTeams;
			// check that the number of maintenance teams is lower than 5 for each day j
			if (numberOfTeams > 5) {
				return 0.0;
			}
			mTCWF1.reset();			
		}
		
		// wind farm 2	
		int[] windFarmTwoMaintenanceTeamsNumberArray = new int[geneLength];
		int[][] windFarmTwoMaintenanceTeamsInvolvedArray = new int[][] {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
		MaintenanceTeamsCounter mTCWF2 = new MaintenanceTeamsCounter();
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmTwoMaintenanceTasks.length; i++) {
				if (windFarmTwoMaintenanceTasks[i][j] == 1) {				
					String maintenanceTeamName = windFarmTwoMaintenanceTasksArrayList
							.get(i).getMaintenanceTeamNames();
					switch (maintenanceTeamName) {
					case "C1":
						mTCWF2.setC1(true);
						mTCWF2.setC1Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C2":
						mTCWF2.setC2(true);
						mTCWF2.setC2Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C3":
						mTCWF2.setC3(true);
						mTCWF2.setC3Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C4":
						mTCWF2.setC4(true);
						mTCWF2.setC4Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C5":
						mTCWF2.setC5(true);
						mTCWF2.setC5Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C6":
						mTCWF2.setC6(true);
						mTCWF2.setC6Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C7":
						mTCWF2.setC7(true);
						mTCWF2.setC7Hours(windFarmTwoMaintenanceTasksArrayList.get(i).getDuration());
						break;
					}					
				}					
			}
			int numberOfTeams = 0;
			if (mTCWF2.isC1()) {
				if (mTCWF2.getC1Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][0] = 1;
			}
			if (mTCWF2.isC2()) {
				if (mTCWF2.getC2Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][1] = 1;
			}			
			if (mTCWF2.isC3()) {
				if (mTCWF2.getC3Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][2] = 1;
			}
			if (mTCWF2.isC4()) {
				if (mTCWF2.getC4Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][3] = 1;
			}
			if (mTCWF2.isC5()) {
				if (mTCWF2.getC5Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][4] = 1;
			}
			if (mTCWF2.isC6()) {
				if (mTCWF2.getC6Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][5] = 1;
			}
			if (mTCWF2.isC7()) {
				if (mTCWF2.getC7Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmTwoMaintenanceTeamsInvolvedArray[j][6] = 1;
			}			
			windFarmTwoMaintenanceTeamsNumberArray[j] = numberOfTeams;
			if (numberOfTeams > 5) {
				return 0.0;
			}
			mTCWF2.reset();			
		}
		
		// wind farm 3
		int[] windFarmThreeMaintenanceTeamsNumberArray = new int[geneLength];
		int[][] windFarmThreeMaintenanceTeamsInvolvedArray = new int[][] {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
		MaintenanceTeamsCounter mTCWF3 = new MaintenanceTeamsCounter();
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmThreeMaintenanceTasks.length; i++) {
				if (windFarmThreeMaintenanceTasks[i][j] == 1) {				
					String maintenanceTeamName = windFarmThreeMaintenanceTasksArrayList
							.get(i).getMaintenanceTeamNames();
					switch (maintenanceTeamName) {
					case "C1":
						mTCWF3.setC1(true);
						mTCWF3.setC1Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C2":
						mTCWF3.setC2(true);
						mTCWF3.setC2Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C3":
						mTCWF3.setC3(true);
						mTCWF3.setC3Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C4":
						mTCWF3.setC4(true);
						mTCWF3.setC4Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C5":
						mTCWF3.setC5(true);
						mTCWF3.setC5Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C6":
						mTCWF3.setC6(true);
						mTCWF3.setC6Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					case "C7":
						mTCWF3.setC7(true);
						mTCWF3.setC7Hours(windFarmThreeMaintenanceTasksArrayList.get(i).getDuration());
						break;
					}					
				}					
			}
			int numberOfTeams = 0;
			if (mTCWF3.isC1()) {
				if (mTCWF3.getC1Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][0] = 1;
			}
			if (mTCWF3.isC2()) {
				if (mTCWF3.getC2Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][1] = 1;
			}			
			if (mTCWF3.isC3()) {
				if (mTCWF3.getC3Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][2] = 1;
			}
			if (mTCWF3.isC4()) {
				if (mTCWF3.getC4Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][3] = 1;
			}
			if (mTCWF3.isC5()) {
				if (mTCWF3.getC5Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][4] = 1;
			}
			if (mTCWF3.isC6()) {
				if (mTCWF3.getC6Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][5] = 1;
			}
			if (mTCWF3.isC7()) {
				if (mTCWF3.getC7Hours() > 7.0) {
					return 0.0;
				}
				numberOfTeams += 1;
				windFarmThreeMaintenanceTeamsInvolvedArray[j][6] = 1;
			}			
			windFarmThreeMaintenanceTeamsNumberArray[j] = numberOfTeams;
			if (numberOfTeams > 5) {
				return 0.0;
			}
			mTCWF3.reset();			
		}
		
		// Check maintenance teams <= 7 at every time j in all the wind farms
		int[] windFarmAllMaintenanceTeamsNumberArray = new int[geneLength];
		for (int j = 0; j < windFarmAllMaintenanceTeamsNumberArray.length; j++) {
			windFarmAllMaintenanceTeamsNumberArray[j] = windFarmOneMaintenanceTeamsNumberArray[j] + 
					windFarmTwoMaintenanceTeamsNumberArray[j] + windFarmThreeMaintenanceTeamsNumberArray[j];
		}
		for (int j = 0; j < windFarmAllMaintenanceTeamsNumberArray.length; j++) {
			if (windFarmAllMaintenanceTeamsNumberArray[j] > 7 ) {
				return 0.0;
			}
		}	
		// Check that the maintenance teams are unique at every time j in each wind farm
		int[][] windFarmAllMaintenanceTeamsInvolvedArray = new int[geneLength][7];
		for (int j = 0; j < windFarmAllMaintenanceTeamsInvolvedArray.length; j++) {
			for (int i = 0; i < windFarmAllMaintenanceTeamsInvolvedArray[j].length; i++) {
				windFarmAllMaintenanceTeamsInvolvedArray[j][i] = windFarmOneMaintenanceTeamsInvolvedArray[j][i] + 
						windFarmTwoMaintenanceTeamsInvolvedArray[j][i] + windFarmThreeMaintenanceTeamsInvolvedArray[j][i];
			}
		}
		for (int j = 0; j < windFarmAllMaintenanceTeamsInvolvedArray.length; j++) {
			for (int i = 0; i < windFarmAllMaintenanceTeamsInvolvedArray[j].length; i++) {
				// This condition forces C1, C2 and C3 to be present on the first day j
				if (j == 0) {
					if (windFarmAllMaintenanceTeamsInvolvedArray[j][0] < 1) {
						return 0.0;
					}
					if (windFarmAllMaintenanceTeamsInvolvedArray[j][1] < 1) {
						return 0.0;
					}
					if (windFarmAllMaintenanceTeamsInvolvedArray[j][2] < 1) {
						return 0.0;
					}
				}				
				if (windFarmAllMaintenanceTeamsInvolvedArray[j][i] > 1) {
					return 0.0;
				}
			}
		}	
		
		// From this point on the constraints are fulfilled by the chromosome instance
		// Calculate the fitness function according to the optimization perspectives
		// Optimize costs (using 5x 4x 3x 2x 1x multipliers)
		// Optimize availability (using weather based priority and task defined priority)		
		
		// Get the wind farm priorities calculated according to the Pot vs. windspeed charts		
		int[] weatherPriorityWindFarmOneArray = this.getWeatherPriorityWindFarmOneArray();
		int[] weatherPriorityWindFarmTwoArray = this.getWeatherPriorityWindFarmTwoArray();
		int[] weatherPriorityWindFarmThreeArray = this.getWeatherPriorityWindFarmThreeArray();	
		
		int[] fitnessArray = new int[3];
		// wind farm 1 fitness value fitnessArray[0]
		int fitnessValue = 0;
		for (int i = 0; i < windFarmOneMaintenanceTasks.length; i++) {			
			for (int j = 0; j < geneLength; j++) {
				int multiplier = 0;
				switch (j) {
				case 0:
					multiplier = 5;
					break;
				case 1:
					multiplier = 4;
					break;
				case 2:
					multiplier = 3;
					break;
				case 3:
					multiplier = 2;
					break;
				case 4:
					multiplier = 1;
					break;
				}
				fitnessValue += multiplier
						* windFarmOneMaintenanceTasks[i][j]
						* windFarmOneMaintenanceTasksArrayList.get(i)
								.getPriority()
						* weatherPriorityWindFarmOneArray[j]
						* calculateTaskWeatherPriority(windFarmOneMaintenanceTasksArrayList.get(i)
								.getWindSpeedLimit(), windFarmOne.getWindSpeedsArray()[j]);
			}
		}
		fitnessArray[0] = fitnessValue;		
		
		// wind farm 2 fitness value fitnessArray[1]
		fitnessValue = 0;
		for (int i = 0; i < windFarmTwoMaintenanceTasks.length; i++) {			
			for (int j = 0; j < geneLength; j++) {
				int multiplier = 0;
				switch (j) {
				case 0:
					multiplier = 5;
					break;
				case 1:
					multiplier = 4;
					break;
				case 2:
					multiplier = 3;
					break;
				case 3:
					multiplier = 2;
					break;
				case 4:
					multiplier = 1;
					break;
				}
				fitnessValue += multiplier
						* windFarmTwoMaintenanceTasks[i][j]
						* windFarmTwoMaintenanceTasksArrayList.get(i)
								.getPriority()
						* weatherPriorityWindFarmTwoArray[j]
						* calculateTaskWeatherPriority(windFarmTwoMaintenanceTasksArrayList.get(i)
								.getWindSpeedLimit(), windFarmTwo.getWindSpeedsArray()[j]);
			}
		}
		fitnessArray[1] = fitnessValue;	
		
		// wind farm 3 fitness value fitnessArray[2]
		fitnessValue = 0;
		for (int i = 0; i < windFarmThreeMaintenanceTasks.length; i++) {			
			for (int j = 0; j < geneLength; j++) {
				int multiplier = 0;
				switch (j) {
				case 0:
					multiplier = 5;
					break;
				case 1:
					multiplier = 4;
					break;
				case 2:
					multiplier = 3;
					break;
				case 3:
					multiplier = 2;
					break;
				case 4:
					multiplier = 1;
					break;
				}
				fitnessValue += multiplier
						* windFarmThreeMaintenanceTasks[i][j]
						* windFarmThreeMaintenanceTasksArrayList.get(i)
								.getPriority()
						* weatherPriorityWindFarmThreeArray[j]
						* calculateTaskWeatherPriority(windFarmThreeMaintenanceTasksArrayList.get(i)
								.getWindSpeedLimit(), windFarmThree.getWindSpeedsArray()[j]);
			}
		}
		fitnessArray[2] = fitnessValue;	
		
		fitnessValue = fitnessArray[0] + fitnessArray[1] + fitnessArray[2];
		
		return (double) fitnessValue;		
	}

	private int calculateTaskWeatherPriority(int windSpeedLimit, int windSpeed) {
		int taskWeatherPriority = 0;
		if (windSpeed < windSpeedLimit) {
			taskWeatherPriority = 2;
		}
		if (windSpeed >= windSpeedLimit) {
			taskWeatherPriority = 1;
		}
		return taskWeatherPriority;
	}
}