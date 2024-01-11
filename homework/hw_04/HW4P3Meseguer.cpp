#include "food.h"
#include "fruit.h"
#include "apple.h"
#include "orange.h"
#include "vegetable.h"
#include "tomato.h"

using namespace std;

int main() {
	//Test food.h
	cout<<"===Test Food.h==="<<endl;
	Food comida02("ceviche");
	comida02.prepare();
	cout<<comida02.getName()<<endl;
	
	//Test fruit.h
	cout<<"===Test Fruit.h==="<<endl;
	Fruit fruta02("pera", 2023, 11, 31);
	cout<<fruta02.getName()<<endl;
	fruta02.prepare();
	fruta02.ripeTime();

	//Test vegetable.h
	cout<<"===Test Vegetable.h==="<<endl;
	Vegetable vegetal02("zanahoria", 2013, 3, 5);
        cout<<vegetal02.getName()<<endl;
        vegetal02.prepare();
        vegetal02.expireTime();
	
	//Test tomato.h
	cout<<"===Test Tomato.h==="<<endl;
	Tomato tom01;
	tom01.prepare();
	tom01.ripeTime();
	tom01.expireTime();
	
	return 0;
}



