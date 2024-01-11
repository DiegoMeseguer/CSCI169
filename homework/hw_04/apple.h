#ifndef APPLE_H
#define APPLE_H

#include "fruit.h"

class Apple: public virtual Fruit {
public:
	Apple();
	Apple(int ann, int mes, int dia);
	void prepare();
};

Apple::Apple()
	:Fruit("apple", 2023, 2, 14) {
}

Apple::Apple(int ann, int mes, int dias)
	:Fruit("apple", ann, mes, dias) {
}

void Apple::prepare() {
	std::cout<<"Core the "<<this->getName()<<std::endl;
}

#endif
