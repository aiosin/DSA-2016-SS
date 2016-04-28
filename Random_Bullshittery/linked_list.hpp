#include <cstddef>
#include <iostream>
#include <string>

namespace cyss
{
	template <typename T>
	class list_node
	{
	public:
		list_node()
		{
			m_Previous = NULL;
			m_Next = NULL;
		}
		~list_node()
		{
			if(m_Next != NULL) delete m_Next;
		}

		void setPrevious(list_node<T>* _previous)
		{
			m_Previous = _previous;
		}
		void setNext(list_node<T>* _next)
		{
			m_Next = _next;
		}
		list_node<T>* getPrevious()
		{
			return m_Previous;
		}
		list_node<T>* getNext()
		{
			return m_Next;
		}

		void setValue(T _value)
		{
			m_Value = _value;
		}
		T getValue()
		{
			return m_Value;
		}
		T& getValueRef()
		{
			return m_Value;
		}
		T* getValuePtr()
		{
			return &m_Value;
		}
	private:
		T m_Value;
		list_node<T>* m_Previous;
		list_node<T>* m_Next;
	};

	template<typename T>
	class list
	{
	public:
		list()
		{
			m_Root = NULL;
			m_Last = NULL;
			m_Count = 0;
		}
		~list()
		{
			delete m_Root;
		}

		void pushBack(T _value)
		{
			if(m_Root == NULL)
			{
				list_node<T>* node = new list_node<T>();
				node->setValue(_value);
				m_Root = node;
				m_Last = node;
				m_Count++;
				return;
			}
			else
			{
				list_node<T>* node = new list_node<T>();
				node->setValue(_value);
				m_Last->setNext(node);
				node->setPrevious(m_Last);
				m_Last = node;
				m_Count++;
				return;
			}
		}
		void pushFront(T _value)
		{
			if(m_Root == NULL)
			{
				list_node<T>* node = new list_node<T>();
				node->setValue(_value);
				m_Root = node;
				m_Last = node;
				m_Count++;
				return;
			}
			else
			{
				list_node<T>* node = list_node<T>();
				node->setValue(_value);
				m_Root->setPrevious(node);
				node->setNext(m_Root);
				m_Root = node;
				m_Count++;
				return;
			}
		}
		void popFront()
		{
			list_node<T>* node = m_Root->getNext();
			list_node<T>* ret = m_Root;
			node->setPrevious(NULL);
			ret->setPrevious(NULL);
			ret->setNext(NULL);
			delete ret;
			m_Root = node; 
			m_Count--;
		}
		void popBack()
		{
			list_node<T>* node = m_Last->getPrevious();
			list_node<T>* ret = m_Last;
			node->setNext(NULL);
			ret->setPrevious(NULL);
			ret->setNext(NULL);
			return ret;
			m_Last = node;
			m_Count--;
		}

		T getBack()
		{
			return m_Last->getValue();
		}
		T& getBackRef()
		{
			return m_Last->getValueRef();
		}
		T* getBackPtr()
		{
			return m_Last->getValuePtr();
		}
		T getFront()
		{
			return m_Root->getValue();
		}
		T& getFrontRef()
		{
			return m_Root->getValueRef();
		}
		T* getFrontPtr()
		{
			return m_Root->getValuePtr();
		}

		T get(int _i)
		{
			if((m_Count - _i) < _i)
			{
				list_node<T>* last = m_Last;
				for(int i = m_Count - 1; i > _i; i--)
				{
					if(last->getPrevious() != NULL)
					{
						last = last->getPrevious();
					}
				}
				return last->getValue();
			}
		    else
			{
				list_node<T>* last = m_Root;
				for(int i = 0; i < _i; i++)
				{
					if(last->getNext() != NULL)
					{
						last = last->getNext();
					}
				}
				return last->getValue();
			}
		}
		T& getRef(int _i)
		{
			if((m_Count - _i) < _i)
			{
				list_node<T>* last = m_Last;
				for(int i = m_Count - 1; i > _i; i--)
				{
					if(last->getPrevious() != NULL)
					{
						last = last->getPrevious();
					}
				}
				return last->getValueRef();
			}
			else
			{
				list_node<T>* last = m_Root;
				for(int i = 0; i < _i; i++)
				{
					if(last->getNext() != NULL)
					{
						last = last->getNext();
					}
				}
				return last->getValueRef();
			}
		}
		T* getPtr(int _i)
		{
			if((m_Count - _i) < _i)
			{
				list_node<T>* last = m_Last;
				for(int i = m_Count -1; i > _i; i--)
				{
					if(last->getPrevious() != NULL)
					{
						last = last->getPrevious();
					}
				}
				return last->getValuePtr();
			}
			else
			{
				list_node<T>* last = m_Root;
				for(int i = 0; i < _i; i++)
				{
					if(last->getNext() != NULL)
					{
						last = last->getNext();
					}
				}
				return last->getValuePtr();
			}
		}

		int getCount()
		{
			return m_Count;
		}

		T& operator[](int _i)
		{
			return getRef(_i);
		}
	private:
		list_node<T>* m_Root;
		list_node<T>* m_Last;
		int m_Count;
	};
}

