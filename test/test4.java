package test;
import java.util.*;
class Node
    {
        int x;
        int y;
        int spend;
        Node(int x,int y,int spend)
        {
            this.x=x;
            this.y=y;
            this.spend=spend;
        }
    }
public class test4 {
    /**
     * 找最短路径问题，给一个二维数组，0表示走水路消耗2，1表示走陆地消耗1，2表示障碍物
     * 求从初始位置即0，0到终点n-1,m-1消耗的最少路径是多少，如果不能到达终点则返回-1
     */
    
     public static void main(String[] args) {
        int[][] matrix={{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        System.out.println(shortPathSum(matrix));
    }
    public static int shortPathSum(int[][] matrix)
    {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
        {
            return 0;
        }
        int r = matrix.length, c = matrix[0].length;
        if(matrix[r-1][c-1]==2)//终点是障碍物不可达
        {
            return -1;
        }
        PriorityQueue<Node> queue=new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.spend-o2.spend;
            }
        });//优先队列，最小堆
        HashSet<Node> visited=new HashSet<>();//防止走回头路
        int []dirx={0,0,1,-1};//可以走的位置，上下左右
        int []diry={1,-1,0,0};
        Node node=new Node(0,0,0);
        queue.offer(node);
        visited.add(node);
        //BFS,从一个节点扩散到四周的节点，然后更新四周节点的花费
        while(!queue.isEmpty())
        {
            Node now=queue.poll();
            if(now.x==r-1&&now.y==c-1)
            {
                return now.spend;
            }
            for(int i=0;i<4;i++)
            {
                //扩散到周围四个节点
                int x=now.x+dirx[i];
                int y=now.y+diry[i];
                if(x<0||y<0||x==r||y==c||matrix[x][y]==2)
                {
                    continue;
                }
                int spend=now.spend;
                if(matrix[x][y]==0)
                {
                    //水路，消耗2,spend是从起始节点到该节点的花费
                    spend+=2;
                }
                else
                {
                    spend+=1;
                }
                Node newNode=new Node(x,y,spend);
                queue.offer(newNode);
                visited.add(newNode);
            }
        }
        return -1;
    }
    
}
