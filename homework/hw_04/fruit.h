#ifndef FRUIT_H
#define FRUIT_H

#include "food.h"

struct Date
{
	int day;
	int month;
	int year;
};

class Fruit: public virtual Food {
protected:
	Date fecha;

public:
	Fruit();
	Fruit(std::string nombre, int ann, int mes, int dia);
	void ripeTime();
};

Fruit::Fruit()
	:Food("fruit") {
	fecha.day = 14;
	fecha.month = 2;
	fecha.year = 2023;
	std::cout<<"Fruit constructor has been called!!"<<std::endl;
}

Fruit::Fruit(std::string nombre, int ann, int mes, int dia)
	:Food(nombre) {
	fecha.day = dia;
	fecha.month = mes;
	fecha.year = ann;
	std::cout<<"Fruit constructor has been called!!"<<std::endl;

}

void Fruit::ripeTime() {
	std::cout<<"You can eat it on: "<<fecha.year<<
	"/"<<fecha.month<<"/"<<fecha.day<<std::endl;
}


#endif


