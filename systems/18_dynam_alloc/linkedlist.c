#include "linkedlist.h"

void print_list(struct node *list) {
  printf("list [%d", list->i);
  int tmp = -1;
  struct node *node = list->next;
  //struct node *node = calloc(1, sizeof(struct node));
  //node = list->next;
  while(1) {
    if(!node) {
      printf("]\n");
      //free(node);
      break;
    }
    printf(", %d", node->i);
    node = node->next;
  }
}

struct node * insert_front(struct node *list, int val) {
  struct node * new_front = malloc(sizeof(struct node));
  new_front->i = val;
  new_front->next = list;
  return new_front;
}

struct node * free_list(struct node *list) {
  struct node * prev = list;
  struct node * node = list->next;
  free(prev);
  while(1) {
    if(!node) break;
    prev = node;
    node = node->next;
    free(prev);
  }
}

/*
int * get_vals(struct node *list) {
  int *arr = malloc(10 * sizeof(int));
  int index = 0;
  struct node node = list;
  while(1) {
    if(node == NULL) break;
    if(index > size) arr = realloc(arr, (index + 1) * sizeof(int));
    arr[index] = node.i;
  }
  return arr;
}
*/
