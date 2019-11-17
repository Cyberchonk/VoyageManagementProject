package com.fdmgroup.dao;

import com.fdmgroup.model.ISavable;

public interface IUpdatable <T extends ISavable>{

	public void update(T t);
	
}
