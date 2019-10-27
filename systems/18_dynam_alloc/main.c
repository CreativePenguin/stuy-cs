# include <stdio.h>
# include "linkedlist.h"

int main() {
  struct node *li1 = calloc(1, sizeof(struct node));
  li1->i = 1;
  li1->next = NULL;
  //struct node li1 = {1, NULL};
  print_list(li1);
  //print_list(&li1);
  struct node li2 = {2, li1};
  //struct node li2 = {2, &li1};
  print_list(&li2);
  struct node *li3 = insert_front(&li2, 3);
  printf("Add 3 to front\n");
  print_list(li3);
  free_list(li1);
  //free_list(&li2);
  //free_list(li3);
  return 0;
}
