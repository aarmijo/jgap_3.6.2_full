package com.tecnalia.epes.tamoin;

public class MaintenanceTeamsCounter {

	private boolean c1 = false;
	private boolean c2 = false;
	private boolean c3 = false;
	private boolean c4 = false;
	private boolean c5 = false;
	private boolean c6 = false;
	private boolean c7 = false;
	
	private int c1Hours = 0;
	private int c2Hours = 0;
	private int c3Hours = 0;
	private int c4Hours = 0;
	private int c5Hours = 0;
	private int c6Hours = 0;
	private int c7Hours = 0;
	
	public boolean isC1() {
		return c1;
	}
	public void setC1(boolean c1) {
		this.c1 = c1;
	}
	public boolean isC2() {
		return c2;
	}
	public void setC2(boolean c2) {
		this.c2 = c2;
	}
	public boolean isC3() {
		return c3;
	}
	public void setC3(boolean c3) {
		this.c3 = c3;
	}
	public boolean isC4() {
		return c4;
	}
	public void setC4(boolean c4) {
		this.c4 = c4;
	}
	public boolean isC5() {
		return c5;
	}
	public void setC5(boolean c5) {
		this.c5 = c5;
	}
	public boolean isC6() {
		return c6;
	}
	public void setC6(boolean c6) {
		this.c6 = c6;
	}
	public boolean isC7() {
		return c7;
	}
	public void setC7(boolean c7) {
		this.c7 = c7;
	}
	public int getC1Hours() {
		return c1Hours;
	}
	public void setC1Hours(int c1Hours) {
		this.c1Hours += c1Hours;
	}
	public int getC2Hours() {
		return c2Hours;
	}
	public void setC2Hours(int c2Hours) {
		this.c2Hours += c2Hours;
	}
	public int getC3Hours() {
		return c3Hours;
	}
	public void setC3Hours(int c3Hours) {
		this.c3Hours += c3Hours;
	}
	public int getC4Hours() {
		return c4Hours;
	}
	public void setC4Hours(int c4Hours) {
		this.c4Hours += c4Hours;
	}
	public int getC5Hours() {
		return c5Hours;
	}
	public void setC5Hours(int c5Hours) {
		this.c5Hours += c5Hours;
	}
	public int getC6Hours() {
		return c6Hours;
	}
	public void setC6Hours(int c6Hours) {
		this.c6Hours += c6Hours;
	}
	public int getC7Hours() {
		return c7Hours;
	}
	public void setC7Hours(int c7Hours) {
		this.c7Hours += c7Hours;
	}
	public void reset() {
		// TODO Auto-generated method stub
		this.c1 = false;
		this.c2 = false;
		this.c3 = false;
		this.c4 = false;
		this.c5 = false;
		this.c6 = false;
		this.c7 = false;
		
		this.c1Hours = 0;
		this.c2Hours = 0;
		this.c3Hours = 0;
		this.c4Hours = 0;
		this.c5Hours = 0;
		this.c6Hours = 0;
		this.c7Hours = 0;
	}
}
