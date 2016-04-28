#include "linked_list.hpp"

#include <iostream>
#include <string>

using namespace cyss;
using namespace std;

int main(int argc, char** argv)
{
	list<int> l;
	l.pushBack(0);
	l.pushBack(1);
	l.pushBack(2);
	l.pushBack(3);
	l.pushBack(4);
	l.pushBack(5);
	l.pushBack(6);
	l.pushBack(7);
	l.pushBack(8);
	l.pushBack(9);
	l.pushBack(10);
	l.pushBack(11);

	cout << "l.getCount(): " << l.getCount() << endl;
	cout << "l.getFront(): " << l.getFront() << endl;
	cout << "l.getBack(): " << l.getBack() << endl;
	cout << "setting l[5] (\"5\") to \"44\"" << endl;

	l[5] = 44;

	for(int i = 0; i < l.getCount(); i++)
	{
		cout << "l[" << i << "]: " << l[i] << endl;
	}

	string s;
	cin >> s;
	return 0;
}