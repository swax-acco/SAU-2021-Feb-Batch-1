package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Supplier {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="suppliers")
	private List<Category> Category = new ArrayList<Category>();

    
    public Supplier(int id, String name) {
        this.id = id;
        this.name = name;
    }
	
	public void addCategory(Category pc)
	{
		this.Category.add(pc);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Category> getCategory() {
		return (ArrayList<Category>) Category;
	}

	public void setCategory(ArrayList<Category> Category) {
		this.Category = Category;
	}

	@Override
	public String toString() {
		return "Supplier: id=" + id + ", name=" + name + ", Category=" + Category;
	}

}
