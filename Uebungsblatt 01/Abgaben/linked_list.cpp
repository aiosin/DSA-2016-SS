
template<typename T>
class Node
{
public:
	Node(T* _value);
	Node(T* _value, Node<T>* _parent);
	~Node();

	T* getData();
	Node<T>* getParent();
	Node<T>* getNext();
	bool getHasNext();
	bool getHasParent();
private:
	T* m_Data;
	Node<T>* m_Parent;
	bool m_HasParent;
	bool m_HasNext;
};


template<typename T>
class LinkedList
{
public:
	LinkedList();
	~LinkedList();

	Node<T>* getRoot();

	
private:
};