package com.tecnalia.epes.tamoin;

import org.jgap.*;
import org.jgap.impl.*;

public class MaintenanceTaskGene extends FixedBinaryGene {

	private static final long serialVersionUID = 1L;
	
	private int duration;

	private int windFarm;
	
	private int windTurbine;
	
	private int maintenanceTeams;
	
	private String name;
	
	private int priority;
	
	private String maintenanceTeamNames;
	
	private int windSpeedLimit;

	// Getter and setters
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDurationSecondDay() {
		return 0;		
	}

	public void setDurationSecondDay(int durationSecondDay) {		
	}
	
	public int getDurationThirdDay() {
		return 0;		
	}

	public void setDurationThirdDay(int durationThirdDay) {		
	}

	public int getWindFarm() {
		return windFarm;
	}

	public void setWindFarm(int windFarm) {
		this.windFarm = windFarm;
	}

	public int getWindTurbine() {
		return windTurbine;
	}

	public void setWindTurbine(int windTurbine) {
		this.windTurbine = windTurbine;
	}

	public int getMaintenanceTeams() {
		return maintenanceTeams;
	}

	public void setMaintenanceTeams(int maintenanceTeams) {
		this.maintenanceTeams = maintenanceTeams;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getMaintenanceTeamNames() {
		return maintenanceTeamNames;
	}

	public void setMaintenanceTeamNames(String maintenanceTeamNames) {
		this.maintenanceTeamNames = maintenanceTeamNames;
	}	
	
	public int getWindSpeedLimit() {
		return windSpeedLimit;
	}

	public void setWindSpeedLimit(int windSpeedLimit) {
		this.windSpeedLimit = windSpeedLimit;		
	}

	// Constructors
	public MaintenanceTaskGene(Configuration a_config, int duration,
			int windFarm, int windTurbine, int maintenanceTeams)
			throws InvalidConfigurationException {
		super(a_config, 5);
		this.duration = duration;
		this.windFarm = windFarm;
		this.windTurbine = windTurbine;
		this.maintenanceTeams = maintenanceTeams;
	}
	
	public MaintenanceTaskGene(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config, 5);
	}

	public MaintenanceTaskGene(Configuration a_config, FixedBinaryGene a_toCopy)
			throws InvalidConfigurationException {
		super(a_config, a_toCopy);
	}

	@Override
	protected Gene newGeneInternal() {
		try {
			MaintenanceTaskGene result = new MaintenanceTaskGene(getConfiguration());
			return result;
		} catch (InvalidConfigurationException iex) {
			throw new IllegalStateException(iex.getMessage());
		}
	}

	@Override
	public void setToRandomValue(final RandomGenerator a_numberGenerator) {
		if (a_numberGenerator == null) {
			throw new IllegalArgumentException(
					"Random Generator must not be null!");
		}
		int pool[][] = { 
				{ 1, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1 } 
		};
		int poolRow[] = pool[a_numberGenerator.nextInt(pool.length)];
		for (int i = 0; i < poolRow.length; i++) {
			setBit(i, poolRow[i]);
		}		
	}
	@Override
	public void applyMutation(final int a_index, final double a_percentage) {
		if (a_index < 0 || a_index >= getLength()) {
			throw new IllegalArgumentException(
					"Index must be between 0 and getLength() - 1");
		}
		if (a_percentage > 0) {
			// Set to random value from the pool
			setToRandomValue(new StockRandomGenerator());
		} 
	}
	
	@Override
	public String toString() {
		int len = getLength();
		String s = "MaintenanceTaskGene {name:" + name + ", duration:"
				+ duration + ", windFarm:" + windFarm + ", windTurbine:"
				+ windTurbine + ", maintenanceTeams:" + maintenanceTeams
				+ ", priority:" + priority + ", maintenanceTeamNames:" + maintenanceTeamNames
				+ ", windSpeedLimit:" + windSpeedLimit
				+ "} [";
		int value;
		for (int i = 0; i < len; i++) {
			if (getBit(i)) {
				value = 1;
			} else {
				value = 0;
			}
			if (i == 0) {
				s += value;
			} else {
				s += "," + value;
			}
		}
		return s + "]";
	}
}
