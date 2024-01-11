#ifndef ORANGE_H
#define ORANGE_H

#include "fruit.h"

class Orange: public virtual Fruit {
public:
        Orange();
        Orange(int ann, int mes, int dia);
        void prepare();
};

Orange::Orange()
        :Fruit("orange", 2023, 2, 14) {
}

Orange::Orange(int ann, int mes, int dias)
        :Fruit("orange", ann, mes, dias) {
}

void Orange::prepare() {
        std::cout<<"Peel the "<<this->getName()<<std::endl;
}

#endif

