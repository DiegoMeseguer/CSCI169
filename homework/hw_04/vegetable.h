#ifndef VEGETABLE_H
#define VEGETABLE_H

#include "food.h"

struct Date_
{
	int day;
	int month;
	int year;
};

class Vegetable: public virtual Food {
protected:
	Date_ expiration;
public:
	Vegetable();
	Vegetable(std::string nombre, int ann, int mes, int dias);
	void expireTime();
};

Vegetable::Vegetable()
	:Food("vegetable") {
	expiration.day = 14;
	expiration.month = 2;
	expiration.year = 2023;
 	std::cout<<"Vegetable constructor has been called!!"<<std::endl;

}

Vegetable::Vegetable(std::string nombre, int ann, int mes, int dia)
	:Food(nombre) {
	expiration.day = dia;
	expiration.month = mes;
	expiration.year = ann;
	std::cout<<"Vegetable constructor has been called!!"<<std::endl;

}

void Vegetable::expireTime() {
	std::cout<<"Expires after: "<<expiration.year<<
	"/"<<expiration.month<<"/"<<expiration.day<<std::endl;
}


#endif
