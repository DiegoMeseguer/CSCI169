#ifndef FOOD_H
#define FOOD_H

#include <iostream>
#include <string>


class Food {
protected:
	std::string name;
public:
	Food();
	Food(std::string nombre);
	void prepare();
	std::string getName();
};


Food::Food() {
	name = "food";
	std::cout<<"Food constructor has been called!!"<<std::endl;
}

Food::Food(std::string nombre) {
	name = nombre;
	std::cout<<"Food constructor has been called!!"<<std::endl;
}


void Food::prepare() {
	std::cout<<"Prepare the "<<name<<std::endl;
}

std::string Food::getName() {
	return name;
}

#endif
	
