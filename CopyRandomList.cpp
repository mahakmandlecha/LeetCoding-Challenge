/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    unordered_map<Node*, Node*> hash;
    
    Node* copyRandomList(Node* head) {
        if(!head) return nullptr;
        
        if(hash[head]) {
            return hash[head];
        }
        Node* newHead = new Node(head->val);
        
        hash[head] = newHead;
        
        newHead->next = copyRandomList(head->next);
        newHead->random = copyRandomList(head->random);
        
        return newHead;
    }
};
