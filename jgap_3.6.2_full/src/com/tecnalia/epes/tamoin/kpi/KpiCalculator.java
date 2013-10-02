package com.tecnalia.epes.tamoin.kpi;

import java.util.ArrayList;

import org.jgap.Gene;
import org.jgap.IChromosome;

import com.tecnalia.epes.tamoin.MaintenanceTaskGene;
import com.tecnalia.epes.tamoin.WindFarm;

public class KpiCalculator {
	
	private ArrayList<MaintenanceTaskGene> windFarmAllMaintenanceTasksArrayList;
	private int[][] windFarmAllMaintenanceTasks;
	
	private ArrayList<MaintenanceTaskGene> windFarmOneMaintenanceTasksArrayList;
	private int[][] windFarmOneMaintenanceTasks;
	
	private ArrayList<MaintenanceTaskGene> windFarmTwoMaintenanceTasksArrayList;
	private int[][] windFarmTwoMaintenanceTasks;
	
	private ArrayList<MaintenanceTaskGene> windFarmThreeMaintenanceTasksArrayList;
	private int[][] windFarmThreeMaintenanceTasks;
	
	private int geneLength;
	
	private int[] weatherPriorityWindFarmOneArray;
	private int[] weatherPriorityWindFarmTwoArray;
	private int[] weatherPriorityWindFarmThreeArray;
	
	public KpiCalculator (IChromosome bestSolutionSoFar, WindFarm[] windFarms) {
		
		int genesNumber = bestSolutionSoFar.size();
		Gene genes[] = bestSolutionSoFar.getGenes();
		this.geneLength = ((MaintenanceTaskGene)genes[0]).getLength();	
		
		this.windFarmAllMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		this.windFarmAllMaintenanceTasks = new int[genesNumber][geneLength];
		for (int i = 0; i < genesNumber; i++) {		
			windFarmAllMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			for (int j = 0; j < geneLength; j++) {
				windFarmAllMaintenanceTasks[i][j] = ((MaintenanceTaskGene)genes[i]).getBit(j)? 1 : 0;
			}
		}
		
		this.windFarmOneMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		this.windFarmTwoMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		this.windFarmThreeMaintenanceTasksArrayList = new ArrayList<MaintenanceTaskGene>();
		for (int i = 0; i < genes.length ; i++) {
			if (((MaintenanceTaskGene) genes[i]).getWindFarm() == 1) {
				windFarmOneMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			} else if (((MaintenanceTaskGene) genes[i]).getWindFarm() == 2) {
				windFarmTwoMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			} else {
				windFarmThreeMaintenanceTasksArrayList.add((MaintenanceTaskGene) genes[i]);
			}
		}
		
		this.windFarmOneMaintenanceTasks = new int[windFarmOneMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmOneMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmOneMaintenanceTasks[i][j] = windFarmOneMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		this.windFarmTwoMaintenanceTasks = new int[windFarmTwoMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmTwoMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmTwoMaintenanceTasks[i][j] = windFarmTwoMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		this.windFarmThreeMaintenanceTasks = new int[windFarmThreeMaintenanceTasksArrayList.size()][geneLength];
		for (int i = 0; i < windFarmThreeMaintenanceTasksArrayList.size(); i++) {			
			for (int j = 0; j < geneLength; j++) {
				windFarmThreeMaintenanceTasks[i][j] = windFarmThreeMaintenanceTasksArrayList.get(i).getBit(j)? 1 : 0;
			}
		}
		
		this.weatherPriorityWindFarmOneArray = windFarms[0].calculateWeatherPriorityArray();
		this.weatherPriorityWindFarmTwoArray = windFarms[1].calculateWeatherPriorityArray();
		this.weatherPriorityWindFarmThreeArray = windFarms[2].calculateWeatherPriorityArray();
	}

	/*
	 * Calculates the number of days with tasks planned in windfarm one
	 */          
	public int calculateNumberOfDaysWindFarmOne() {
		int numberOfDays = 0;
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmOneMaintenanceTasks.length; i++) {
				if (windFarmOneMaintenanceTasks[i][j] == 1) {
					numberOfDays += 1;
					break;
				}
			}
		}
		return numberOfDays;
	}
	
	/*
	 * Calculates the number of days with tasks planned in windfarm two
	 */ 
	public int calculateNumberOfDaysWindFarmTwo() {
		int numberOfDays = 0;
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmTwoMaintenanceTasks.length; i++) {
				if (windFarmTwoMaintenanceTasks[i][j] == 1) {
					numberOfDays += 1;
					break;
				}
			}
		}
		return numberOfDays;
	}
	
	/*
	 * Calculates the number of days with tasks planned in windfarm three
	 */ 
	public int calculateNumberOfDaysWindFarmThree() {
		int numberOfDays = 0;
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmThreeMaintenanceTasks.length; i++) {
				if (windFarmThreeMaintenanceTasks[i][j] == 1) {
					numberOfDays += 1;
					break;
				}
			}
		}
		return numberOfDays;
	}
	
	/*
	 * Calculates the number of days with tasks planned within all the windfarms
	 */
	public int calculateNumberOfDaysWindFarmAll() {
		int numberOfDays = 0;
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmAllMaintenanceTasks.length; i++) {
				if (windFarmAllMaintenanceTasks[i][j] == 1) {
					numberOfDays += 1;
					break;
				}
			}
		}
		return numberOfDays;
	}
	
	/*
	 * Calculates the ratio between number of tasks and number of days with planned tasks 
	 * in wind farm one
	 */ 
	public double calculateTasksPerNumberOfDaysWindFarmOne() {		
		double dA = new Double(windFarmOneMaintenanceTasks.length);
		double dB = new Double(calculateNumberOfDaysWindFarmOne());
		return dA/dB;
	}
	
	/*
	 * Calculates the ratio between number of tasks and number of days with planned tasks 
	 * in wind farm two
	 */ 
	public double calculateTasksPerNumberOfDaysWindFarmTwo() {		
		double dA = new Double(windFarmTwoMaintenanceTasks.length);
		double dB = new Double(calculateNumberOfDaysWindFarmTwo());
		return dA/dB;
	}
	
	/*
	 * Calculates the ratio between number of tasks and number of days with planned tasks 
	 * in wind farm three
	 */ 
	public double calculateTasksPerNumberOfDaysWindFarmThree() {		
		double dA = new Double(windFarmThreeMaintenanceTasks.length);
		double dB = new Double(calculateNumberOfDaysWindFarmThree());
		return dA/dB;
	}
	
	/*
	 * Calculates the ratio between number of tasks and number of days with planned tasks
	 */ 
	public double calculateTasksPerNumberOfDaysWindFarmAll() {		
		double dA = new Double(windFarmAllMaintenanceTasks.length);
		double dB = new Double(calculateNumberOfDaysWindFarmAll());
		return dA/dB;
	}
	
	/*
	 * Calculates the kilometers travelled by the maintenance teams
	 */
	public int calculateKmTraveled() {		
		int legs = 0;		
		for (int j = 0; j < geneLength; j++) {
			int[] maintenanceTeamsWindFarmAll = {0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < windFarmAllMaintenanceTasks.length; i++) {
				if (windFarmAllMaintenanceTasks[i][j] == 1) {
					String maintenanceTeamName = windFarmAllMaintenanceTasksArrayList
							.get(i).getMaintenanceTeamNames();
					switch (maintenanceTeamName) {
					case "C1":
						if (maintenanceTeamsWindFarmAll[0] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[0] = 1;
						}
						break;
					case "C2":
						if (maintenanceTeamsWindFarmAll[1] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[1] = 1;
						}
						break;
					case "C3":
						if (maintenanceTeamsWindFarmAll[2] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[2] = 1;
						}
						break;
					case "C4":
						if (maintenanceTeamsWindFarmAll[3] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[3] = 1;
						}
						break;
					case "C5":
						if (maintenanceTeamsWindFarmAll[4] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[4] = 1;
						}
						break;
					case "C6":
						if (maintenanceTeamsWindFarmAll[5] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[5] = 1;
						}
						break;
					case "C7":
						if (maintenanceTeamsWindFarmAll[6] == 0) {
							legs += 2;
							maintenanceTeamsWindFarmAll[6] = 1;
						}
						break;
					default:
						String[] teamNamesArray = maintenanceTeamName
								.split("\\s*,\\s*");
						for (int k = 0; k < teamNamesArray.length; k++) {
							switch (teamNamesArray[k]) {
							case "C1":
								if (maintenanceTeamsWindFarmAll[0] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[0] = 1;
								}
								break;
							case "C2":
								if (maintenanceTeamsWindFarmAll[1] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[1] = 1;
								}
								break;
							case "C3":
								if (maintenanceTeamsWindFarmAll[2] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[2] = 1;
								}
								break;
							case "C4":
								if (maintenanceTeamsWindFarmAll[3] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[3] = 1;
								}
								break;
							case "C5":
								if (maintenanceTeamsWindFarmAll[4] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[4] = 1;
								}
								break;
							case "C6":
								if (maintenanceTeamsWindFarmAll[5] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[5] = 1;
								}
								break;
							case "C7":
								if (maintenanceTeamsWindFarmAll[6] == 0) {
									legs += 2;
									maintenanceTeamsWindFarmAll[6] = 1;
								}
								break;
							}
						}
						break;
					}
				}
			}
		}
		int kilometers = legs * 100;
		return kilometers;
	}
	
	/*
	 * Calculate the CO2 emissions (g)
	 */
	public double calculateCo2Emissions() {
		double kmTravelled = new Double(calculateKmTraveled());
		return kmTravelled*95;
	}
	
	/*
	 * Calculate the availability for the wind farms
	 */
	public double [][] calculateAvailabilityPerWindFarms() {		

		double availabilityReduction = 0.0d;
		int tasksDuration = 0;
		int numberOfTasks = 0;
		double [][] windFarmAllAvailability = new double [3][geneLength];
		
		// wind farm one
		double [] windFarmOneAvailability = new double [geneLength];
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmOneMaintenanceTasks.length; i++) {
				if (windFarmOneMaintenanceTasks[i][j] == 1) {
					tasksDuration += windFarmOneMaintenanceTasksArrayList
							.get(i).getDuration();
					numberOfTasks += 1;
				}
			}
			switch (weatherPriorityWindFarmOneArray[j]) {
			case 1:
				availabilityReduction = 100.0d;
				break;
			case 2:
				availabilityReduction = 75.0d;
				break;
			case 3:
				availabilityReduction = 25.0d;
				break;
			case 4:
				availabilityReduction = 0.0d;
				break;
			}
			if (numberOfTasks == 0) {
				windFarmOneAvailability[j] = 100;
			} else {
				windFarmOneAvailability[j] = 100 - tasksDuration * availabilityReduction
						/ 24.0d / numberOfTasks;
			}
			availabilityReduction = 0.0d;
			tasksDuration = 0;
			numberOfTasks = 0;
		}
		
		// wind farm two
		double [] windFarmTwoAvailability = new double [geneLength];
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmTwoMaintenanceTasks.length; i++) {
				if (windFarmTwoMaintenanceTasks[i][j] == 1) {
					tasksDuration += windFarmTwoMaintenanceTasksArrayList
							.get(i).getDuration();
					numberOfTasks += 1;
				}
			}
			switch (weatherPriorityWindFarmTwoArray[j]) {
			case 1:
				availabilityReduction = 100.0d;
				break;
			case 2:
				availabilityReduction = 75.0d;
				break;
			case 3:
				availabilityReduction = 25.0d;
				break;
			case 4:
				availabilityReduction = 0.0d;
				break;
			}
			if (numberOfTasks == 0) {
				windFarmTwoAvailability[j] = 100;
			} else {
				windFarmTwoAvailability[j] = 100 - tasksDuration * availabilityReduction
						/ 24.0d / numberOfTasks;
			}
			availabilityReduction = 0.0d;
			tasksDuration = 0;
			numberOfTasks = 0;
		}
		
		// wind farm three
		double [] windFarmThreeAvailability = new double [geneLength];
		for (int j = 0; j < geneLength; j++) {
			for (int i = 0; i < windFarmThreeMaintenanceTasks.length; i++) {
				if (windFarmThreeMaintenanceTasks[i][j] == 1) {
					tasksDuration += windFarmThreeMaintenanceTasksArrayList
							.get(i).getDuration();
					numberOfTasks += 1;
				}
			}
			switch (weatherPriorityWindFarmThreeArray[j]) {
			case 1:
				availabilityReduction = 100.0d;
				break;
			case 2:
				availabilityReduction = 75.0d;
				break;
			case 3:
				availabilityReduction = 25.0d;
				break;
			case 4:
				availabilityReduction = 0.0d;
				break;
			}
			if (numberOfTasks == 0) {
				windFarmThreeAvailability[j] = 100;
			} else {
				windFarmThreeAvailability[j] = 100 - tasksDuration * availabilityReduction
						/ 24.0d / numberOfTasks;
			}
			availabilityReduction = 0.0d;
			tasksDuration = 0;
			numberOfTasks = 0;
		}
		
		windFarmAllAvailability[0] = windFarmOneAvailability;
		windFarmAllAvailability[1] = windFarmTwoAvailability;
		windFarmAllAvailability[2] = windFarmThreeAvailability;
		
		return windFarmAllAvailability;
	}
	
	/*
	 * Calculate the total average availability
	 */
	public double calculateAvailability() {
		double[][] availabilities = calculateAvailabilityPerWindFarms();
		double[] averageAvailabilities = new double[geneLength];
		for (int j = 0; j < availabilities[0].length; j++) {
			double availabilitySummatory = 0.0;
			for (int i = 0; i < availabilities.length; i++) {
				availabilitySummatory += availabilities[i][j];
			}
			averageAvailabilities[j] = availabilitySummatory/availabilities.length;
		}
		return (averageAvailabilities[0] + averageAvailabilities[1] + 
				averageAvailabilities[2] + averageAvailabilities[3] +
				averageAvailabilities[4])/geneLength;
	}
	
	/*
	 * Calculate the average wind farm one availability
	 */
	public double calculateWindFarmOneAvailability() {
		double[][] availabilities = calculateAvailabilityPerWindFarms();
		double[] windFarmOneAvailabilities = availabilities[0];		
		return (windFarmOneAvailabilities[0] + windFarmOneAvailabilities[1] + 
				windFarmOneAvailabilities[2] + windFarmOneAvailabilities[3] +
				windFarmOneAvailabilities[4])/geneLength;
	}
	
	/*
	 * Calculate the average wind farm two availability
	 */
	public double calculateWindFarmTwoAvailability() {
		double[][] availabilities = calculateAvailabilityPerWindFarms();
		double[] windFarmTwoAvailabilities = availabilities[1];		
		return (windFarmTwoAvailabilities[0] + windFarmTwoAvailabilities[1] + 
				windFarmTwoAvailabilities[2] + windFarmTwoAvailabilities[3] +
				windFarmTwoAvailabilities[4])/geneLength;
	}
	
	/*
	 * Calculate the average wind farm three availability
	 */
	public double calculateWindFarmThreeAvailability() {
		double[][] availabilities = calculateAvailabilityPerWindFarms();
		double[] windFarmThreeAvailabilities = availabilities[2];		
		return (windFarmThreeAvailabilities[0] + windFarmThreeAvailabilities[1] + 
				windFarmThreeAvailabilities[2] + windFarmThreeAvailabilities[3] +
				windFarmThreeAvailabilities[4])/geneLength;
	}
}
