#ifndef TOMATO_H
#define TOMATO_H

#include "tomato.h"

class Tomato: public Vegetable, public Fruit {
public:
	Tomato();
	Tomato(int eann, int emes, int edias,
		int rann, int rmes, int rdias, std::string nombre);
};

Tomato::Tomato()
	:Fruit("nombre", 2023, 1, 10), Vegetable("nombre", 2023, 2, 14) {
	std::cout<<"Tomato constructor has been called!!"<<std::endl;
}

Tomato::Tomato(int eann, int emes, int edias,
                int rann, int rmes, int rdias, std::string nombre)
	:Fruit(nombre, rann, rmes, rdias), Vegetable(nombre, eann, emes, edias) {
	std::cout<<"Tomato constructor has been called!!"<<std::endl;;
}


#endif
