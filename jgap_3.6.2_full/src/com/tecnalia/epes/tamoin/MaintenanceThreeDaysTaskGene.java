package com.tecnalia.epes.tamoin;

import org.jgap.*;
import org.jgap.impl.*;

public class MaintenanceThreeDaysTaskGene extends MaintenanceTaskGene {

	private static final long serialVersionUID = 1L;
	
	private int durationSecondDay;
	
	private int durationThirdDay;
	
	public int getDurationSecondDay() {
		return durationSecondDay;
	}
	
	public void setDurationSecondDay(int durationSecondDay) {
		this.durationSecondDay = durationSecondDay;
	}
	
	public int getDurationThirdDay() {
		return durationThirdDay;
	}

	public void setDurationThirdDay(int durationThirdDay) {
		this.durationThirdDay = durationThirdDay;
	}
	
	// Constructors
	public MaintenanceThreeDaysTaskGene(Configuration a_config, int duration, int durationSecondDay,
			int durationThirdDay, int windFarm, int windTurbine, int maintenanceTeams)
			throws InvalidConfigurationException {
		super(a_config, duration,
				windFarm, windTurbine, maintenanceTeams);
		this.setDurationSecondDay(durationSecondDay);
		this.setDurationThirdDay(durationThirdDay);
		this.setMaintenanceTeams(4);
	}
	
	public MaintenanceThreeDaysTaskGene(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config);
	}
	
	public MaintenanceThreeDaysTaskGene(Configuration a_config, FixedBinaryGene a_toCopy)
			throws InvalidConfigurationException {
		super(a_config, a_toCopy);
	}

	@Override
	protected Gene newGeneInternal() {
		try {
			MaintenanceThreeDaysTaskGene result = new MaintenanceThreeDaysTaskGene(getConfiguration());
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
				{ 1, 1, 1, 0, 0 }, 
				{ 0, 1, 1, 1, 0 },
				{ 0, 0, 1, 1, 1 }								
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
		String s = "MaintenanceThreeDaysTaskGene {name:" + this.getName() + ", duration:"
				+ this.getDuration() + ", durationSecondDay:"
				+ this.getDurationSecondDay() + ", durationThirdDay:"  
				+ this.getDurationThirdDay() + ", windFarm:" + this.getWindFarm() + ", windTurbine:"
				+ this.getWindTurbine() + ", maintenanceTeams:" + this.getMaintenanceTeams()
				+ ", priority:" + this.getPriority() + ", maintenanceTeamNames:" + this.getMaintenanceTeamNames()
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
