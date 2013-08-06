package com.tecnalia.epes.tamoin;

public class WindFarm {

	private int windFarm;
	
	private int windSpeedMonday;
	
	protected int windSpeedTuesday;
	
	protected int windSpeedWednesday;
	
	protected int windSpeedThursday;
	
	protected int windSpeedFriday;
	
	public int getWindFarm() {
		return windFarm;
	}

	public void setWindFarm(int windFarm) {
		this.windFarm = windFarm;
	}
	

	public int getWindSpeedMonday() {
		return windSpeedMonday;
	}

	public void setWindSpeedMonday(int windSpeedMonday) {
		this.windSpeedMonday = windSpeedMonday;
	}

	public int getWindSpeedTuesday() {
		return windSpeedTuesday;
	}

	public void setWindSpeedTuesday(int windSpeedTuesday) {
		this.windSpeedTuesday = windSpeedTuesday;
	}

	public int getWindSpeedWednesday() {
		return windSpeedWednesday;
	}

	public void setWindSpeedWednesday(int windSpeedWednesday) {
		this.windSpeedWednesday = windSpeedWednesday;
	}

	public int getWindSpeedThursday() {
		return windSpeedThursday;
	}

	public void setWindSpeedThursday(int windSpeedThursday) {
		this.windSpeedThursday = windSpeedThursday;
	}

	public int getWindSpeedFriday() {
		return windSpeedFriday;
	}

	public void setWindSpeedFriday(int windSpeedFriday) {
		this.windSpeedFriday = windSpeedFriday;
	}

	public int[] calculateWeatherPriorityArray(){
		
		int weatherPriorityMonday = 0;
		int weatherPriorityTuesday = 0;
		int weatherPriorityWednesday = 0;
		int weatherPriorityThursday = 0;
		int weatherPriorityFriday = 0;
		
		int windSpeed = this.windSpeedMonday;
		if (windSpeed < 3) {
			weatherPriorityMonday = 4;
		}		
		if (windSpeed > 35) {
			weatherPriorityMonday = 1;
		}
		if (windSpeed >= 3 && windSpeed < 11) {
			weatherPriorityMonday = 3;
		}
		if (windSpeed >= 11 && windSpeed < 20) {
			weatherPriorityMonday = 2;
		}
		if (windSpeed >= 20 && windSpeed < 35) {
			weatherPriorityMonday = 1;
		}
		
		windSpeed = this.windSpeedTuesday;
		if (windSpeed < 3) {
			weatherPriorityTuesday = 4;
		}		
		if (windSpeed > 35) {
			weatherPriorityTuesday = 1;
		}
		if (windSpeed >= 3 && windSpeed < 11) {
			weatherPriorityTuesday = 3;
		}
		if (windSpeed >= 11 && windSpeed < 20) {
			weatherPriorityTuesday = 2;
		}
		if (windSpeed >= 20 && windSpeed < 35) {
			weatherPriorityTuesday = 1;
		}
		
		windSpeed = this.windSpeedWednesday;
		if (windSpeed < 3) {
			weatherPriorityWednesday = 4;
		}		
		if (windSpeed > 35) {
			weatherPriorityWednesday = 1;
		}
		if (windSpeed >= 3 && windSpeed < 11) {
			weatherPriorityWednesday = 3;
		}
		if (windSpeed >= 11 && windSpeed < 20) {
			weatherPriorityWednesday = 2;
		}
		if (windSpeed >= 20 && windSpeed < 35) {
			weatherPriorityWednesday = 1;
		}
		
		windSpeed = this.windSpeedThursday;
		if (windSpeed < 3) {
			weatherPriorityThursday = 4;
		}		
		if (windSpeed > 35) {
			weatherPriorityThursday = 1;
		}
		if (windSpeed >= 3 && windSpeed < 11) {
			weatherPriorityThursday = 3;
		}
		if (windSpeed >= 11 && windSpeed < 20) {
			weatherPriorityThursday = 2;
		}
		if (windSpeed >= 20 && windSpeed < 35) {
			weatherPriorityThursday = 1;
		}
		
		windSpeed = this.windSpeedFriday;
		if (windSpeed < 3) {
			weatherPriorityFriday = 4;
		}		
		if (windSpeed > 35) {
			weatherPriorityFriday = 1;
		}
		if (windSpeed >= 3 && windSpeed < 11) {
			weatherPriorityFriday = 3;
		}
		if (windSpeed >= 11 && windSpeed < 20) {
			weatherPriorityFriday = 2;
		}
		if (windSpeed >= 20 && windSpeed < 35) {
			weatherPriorityFriday = 1;
		}
		
		return new int[] {weatherPriorityMonday, weatherPriorityTuesday, 
				weatherPriorityWednesday, weatherPriorityThursday, weatherPriorityFriday};		
	}
		
	public WindFarm(int windFarm, int windSpeedMonday, int windSpeedTuesday,
			int windSpeedWednesday, int windSpeedThursday, int windSpeedFriday) {
		super();
		this.windFarm = windFarm;
		this.windSpeedMonday = windSpeedMonday;
		this.windSpeedTuesday = windSpeedTuesday;
		this.windSpeedWednesday = windSpeedWednesday;
		this.windSpeedThursday = windSpeedThursday;
		this.windSpeedFriday = windSpeedFriday;
	}	
	
	public int[] getWindSpeedsArray() {
		return new int[] {windSpeedMonday, windSpeedTuesday, windSpeedWednesday,
				windSpeedThursday, windSpeedFriday};
	}
}
