struct node { int i; struct node *next; };

void print_list(struct node *list);
struct node * insert_front(struct node *list, int val);
struct node * free_list(struct node *list);
