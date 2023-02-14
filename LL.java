

class LL{
    Node head;
   private int size;
   //LL constructor
   LL(){
       this.size = 0;
   }
   
    class Node{
       int data;
        Node next;
//Node constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }


    }


    //add - first

      public void addFirst(int data){
         Node newNode =new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
      }

      //add last
      public void addLast(int data){
          Node newNode =new Node(data);
          if(head == null){
              head = newNode;
              return;
          }

          Node curNode =head;
          while(curNode.next!=null){
               curNode = curNode.next;
          }
          curNode.next = newNode;
          size++;
      }
    

      // print
      public void printList(){
        if(head == null){
            System.out.println("List is Empty");
        }
        Node curNode = head;
        while(curNode!=null){
            System.out.print(curNode.data + "->");
             curNode = curNode.next;
        }
        System.out.print("Null");
        System.out.println("");
    
      }

      // delete first

      public void deleteFirst(){
        if(head == null){
            System.out.println("this list is empty");
           return;

        }
         size--;
        head = head.next;

      }

      //delete last

      public void deleteLast()
    {
        if(head == null){
            System.out.println("this list is empty");
           return;
        }
        size--;
        if(head.next == null){
            head =null;
            return;
        }

        Node seccondLast =head;
        Node lastNode =head.next;
        while(lastNode.next !=null){
              lastNode = lastNode.next;
              seccondLast =seccondLast.next;
        }
        seccondLast.next=null;
    }


    // size
    public int getSize (){
          return size;
    }

      public void reverseIterate(){
       
         if(head == null || head.next == null){
               
            return;
     }


        Node prevNode =head;
        Node curNode = head.next;
        while(curNode != null){
            Node nextNode =curNode.next;
            curNode.next =prevNode;

            //update
            prevNode = curNode;
            curNode  = nextNode;

        }
          head.next = null;
          head = prevNode;

      }


         public Node reverseRecursive(Node head){
          if(head ==null || head.next == null){
             return head;
          } 

           Node newHead= reverseRecursive(head.next);
           head.next.next = head;
           head.next =null;
           return newHead;

         }


    public static void main(String args[]){
         LL list =new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
                  

      
         
          
           
            list.reverseIterate();
            list.printList(); 
            
         list.head = list.reverseRecursive(list.head);
            list.printList();

    }
}