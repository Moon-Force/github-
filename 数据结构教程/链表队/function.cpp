#include<stdio.h>
#include<malloc.h>
typedef int ElemType;
typedef struct qnode {
	ElemType data;
	struct qnode* next;
}DataNode;
typedef struct {
	DataNode* front;
	DataNode* rear;
}LinkQuNode;
void InitQueue(LinkQuNode*& q) {
	q = (LinkQuNode*)malloc(sizeof(LinkQuNode));
	q->front = q->rear = NULL;
}
void DestroyQueue(LinkQuNode *&q) {
	DataNode* pre = q->front, * p;
	if (pre != NULL) {
	 p = pre->next;
		while(p!=NULL){
		free(pre);
		pre = p;
		p = p->next;
		}
	}
}
bool QueueEmpty(LinkQuNode* q) {
	return(q->rear == NULL);
}
void enQueue(LinkQuNode*& q, ElemType e) {
	DataNode* p;
	p = (DataNode*)malloc(sizeof(DataNode));
	p->data = e;
	p->next = NULL;
	if (q->rear == NULL) {
		q->front = q->rear = p;
	}
	else {
		q->rear->next = p;
		q->rear = p;
	}
}
bool deQueue(LinkQuNode*& q, ElemType& e) {
	DataNode* t;
	if (q->rear == NULL) {
		return false;
	}
	t = q->front;
	if (q->front == q->rear) {
		q->front = q->rear = NULL;
	}
	else {
		q->front = q->front->next;
	}
	e = t->data;
	free(t);
	return true;
}