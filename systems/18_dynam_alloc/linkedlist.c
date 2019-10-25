#include "linkedlist.h"
# define getName(var) #var

void print_list(struct node *list) {
  printf("%s [", getName(list));
  struct node *node = list;
  while(1) {
    int fuckyou = node == 0x0;
    if(node == 0x0) {
      printf("&i]\n", node->i);
      break;
    }
    printf("%i, ", node->i);
    node = list->next;
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
    if(node == NULL) break;
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
