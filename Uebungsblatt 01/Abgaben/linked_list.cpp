#include <string>
#include <iostream>

template<typename T>
class Node
{
public:
	Node(T _value)
	{
		m_Data = _value;
		m_HasParent = false;
		m_HasNext = false;
		m_Parent = NULL;
		m_Next = NULL;
	}
	~Node()
	{
		if(m_HasNext)
		{
			delete m_Next;
		}
	}
	void insertAfter(Node<T>* _item)
	{
		m_Next = _item;
		m_HasNext = true;
		_item->insertBefore(this);
	}
	void insertBefore(Node<T>* _item)
	{
		if(m_HasParent)
		{
			m_Parent->insertAfter(_item);
			_item->insertAfter(this);
		}
		else
		{
			m_Parent = _item;
			m_HasParent = true;
		}
	}
	T getData()
	{
		return m_Data;
	}
	Node<T>* getParent()
	{
		return m_Parent;
	}
	Node<T>* getNext()
	{
		return m_Next;
	}
	bool getHasNext()
	{
		return m_HasNext;
	}
	bool getHasParent()
	{
		return m_HasParent;
	}
private:
	T m_Data;
	Node<T>* m_Parent;
	Node<T>* m_Next;
	bool m_HasParent;
	bool m_HasNext;
};


template<typename T>
class LinkedList
{
public:
	LinkedList()
	{
		m_Root = NULL;
		m_HasRoot = false;
	}
	~LinkedList()
	{
		if(m_HasRoot)
		{
			delete m_Root;
		}
	}
	Node<T>* getRoot()
	{
		if(m_HasRoot)
		{
			return m_Root;
		}
		else
		{
			return NULL;
		}
	}
	Node<T>* getLast()
	{
		if(m_HasRoot)
		{
			Node<T>* last = m_Root;
			while(true)
			{
				if(last->getHasNext())
				{
					last = last->getNext();
				}
				else
				{
					break;
				}
			}
			return last;
		}
		else
		{
			return NULL;
		}
	}

	void pushFront(T _value)
	{
		if(m_HasRoot)
		{
			Node<T>* node = new Node<T>(_value);
			node->insertAfter(m_Root);
			m_Root = node;
		}
		else
		{
			m_Root = new Node<T>(_value);
			m_HasRoot = true;
		}
	}
	void pushBack(T _value)
	{
		if(m_HasRoot)
		{
			Node<T>* last = m_Root;
			while(true)
			{
				if(last->getHasNext())
				{
					last = last->getNext();
				}
				else
				{
					break;
				}
			}
			Node<T>* node = new Node<T>(_value);
			last->insertAfter(node);
			return;
		}
		else
		{
			m_Root = new Node<T>(_value);
			m_HasRoot = true;
		}
	}

	T operator[](int _i)
	{
		Node<T>* last = m_Root;
		for(int i = 0; i < _i; i++)
		{
			if(last->getHasNext())
			{
				last = last->getNext();
			}
			else
			{
				break;
			}
		}
		return last->getData();
	}


	int getCount()
	{
		if(m_HasRoot)
		{
			Node<T>* last = m_Root;
			int i = 1;
			while(true)
			{
				if(last->getHasNext())
				{
					last = last->getNext();
					i++;
				}
				else
				{
					break;
				}
			}
			return i;
		}
		else
		{
			return 0;
		}
	}
private:
	Node<T>* m_Root;
	bool m_HasRoot;
};


int main(int argc, char** argv)
{
	LinkedList<int> l;
	l.pushBack(0);
	l.pushBack(1);
	l.pushBack(2);
	l.pushBack(3);
	l.pushFront(-1);
	l.pushFront(-2);
	l.pushFront(-3);
	l.pushBack(4);
	l.pushBack(5);
	int count = l.getCount();
	std::cout << "count: " << count << std::endl;
	for(int i = 0; i < count; i++)
	{
		std::cout << "Value at [" << i << "]: " << l[i] << std::endl;
	}
	std::string s;
	std::cin >> s;
	return 0;
}