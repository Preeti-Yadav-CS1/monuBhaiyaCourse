// public class addTwoPolynomial {
//     class polyNode{

//     }
//     class solution{
//         public polyNode addPoly(polyNode l1, polyNode l2){
//             polyNode dummy= new polyNode();
//             polyNode temp= dummy;
//             while(l1!=null && l2!=null){
//                 if(l1.power==l2.power){
//                     if(l1.coefficient+ l2.coefficient!=0){
//                         polyNode newNode= new polyNode(l1.coefficient+ l2.coefficient, l1.power);
//                         dummy.next= newNode;
//                         dummy= dummy.next;
//                     }
//                         l1=l1.next;
//                         l2= l2.next;
//                 }else if(l1.power>l2.power){
//                     polyNode newNode= new polyNode(l1.coefficient, l1.power);
//                     dummy.next= newNode;
//                     dummy= dummy.next;
//                     l1=l1.next;
//                 }
//                 else{
//                     polyNode newNode= new polyNode(l2.coefficient, l2.power);
//                     dummy.next= newNode;
//                     dummy= dummy.next;
//                     l2=l2.next;
                    
//                 }
//             }
//             if(l1!=null)
//                 dummy.next=l1;
//             if(l2!=null)
//                 dummy.next=l2;
//             return temp.next;

//         }
//     }
// }
