package com.fdmgroup.dao;

import com.fdmgroup.model.ISavable;

public interface IDeletable <T extends ISavable>{

	public boolean delete(T t);
	
}
