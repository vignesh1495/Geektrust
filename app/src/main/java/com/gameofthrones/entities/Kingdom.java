package com.gameofthrones.entities;

import java.util.Objects;

public class Kingdom {

	private Integer id;
	private String name;
	private String emblem;


	public Kingdom(Integer id,String name,String emblem) {
		this.id=id;
		this.name=name;
		this.emblem=emblem;
	}

    @Override
	public String toString() {
		return "Kingdom [id=" + id + ", name=" + name + ", emblem=" + emblem + "]";
	} 
	
	public Integer getid() {
		return id;
	}
	
	public void setid(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmblem() {
		return emblem;
	}
	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kingdom)) return false;
        Kingdom kingdom = (Kingdom) o;
        return getid().equals(kingdom.getid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getid());
    }
    
}