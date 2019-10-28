# include <stdio.h>
# include "linkedlist.h"

int main() {
  struct node *li1 = calloc(1, sizeof(struct node));
  li1->i = 1;
  li1->next = NULL;
  //struct node li1 = {1, NULL};
  print_list(li1);
  //print_list(&li1);
  //struct node li2 = {2, &li1};
  struct node *li2 = calloc(1, sizeof(struct node));
  li2->i = 2;
  li2->next = li1;
  print_list(li2);

  struct node * li3 = malloc(sizeof(struct node));
  li3 = insert_front(li2, 3);
  printf("Add 3 to front\n");
  struct node * li4 = malloc(sizeof(struct node));
  li4 = insert_front(li3, 4);
  printf("Add 4 to front\n");
  print_list(li4);
  struct node * li5 = malloc(sizeof(struct node));
  li5 = insert_front(li4, 5);
  printf("Add 5 to front\n");
  print_list(li5);

  remove_data(li5, 3);
  //free_list(li2);
  //free_list(li1);
  free_list(li5);
  return 0;
}
