package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Mar 18, 2021
 */

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String manufacturer;
	private String model;
	private boolean foldable;
	private int cpuCores;
	
	public Phone() {
		super();
		foldable = false;
	}

	public Phone(String model) {
		this.model = model;
	}

	public Phone(String manufacturer, String model) {
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public Phone(String manufacturer, String model, boolean foldable, int cpuCores) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.foldable = foldable;
		this.cpuCores = cpuCores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isFoldable() {
		return foldable;
	}

	public void setFoldable(boolean foldable) {
		this.foldable = foldable;
	}

	public int getCpuCores() {
		return cpuCores;
	}

	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", foldable=" + foldable
				+ ", cpuCores=" + cpuCores + "]";
	}
	
	
	
}
