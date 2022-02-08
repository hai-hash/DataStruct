/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuatoan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Hai
 */
public class BCAModel {
    private static int m,n;
    private static boolean tearch[][];
    private static boolean  conflict[][];
    private static int X[] = new int[1000];
    public static int ans = 0;
    public static int min_value = 2147483647;
    public void loadData(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        tearch = new boolean[m+1][n+1];
        for(int i = 1;i<= m;i++){
            for(int j = 1;j<= n;j++){
                tearch[i][j] = false;
            }
        }
        for(int i =1;i<= m;i++ ){
            int countCourse = sc.nextInt();
            for(int j = 0; j< countCourse;j++){
                int x;
                x = sc.nextInt();
                tearch[i][x] = true;
                
            }
        }
        int k;
        k = sc.nextInt();
        conflict = new boolean[n+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<= n;j++){
                conflict[i][j] = false;
            }
        }
        for(int i = 0;i<k;i++){
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            conflict[x][y] = true;
        }
    }
    public boolean check(int tearch, int course){
        for(int i = 1;i< course;i++){
            if(X[i] == tearch && (conflict[i][course] == true || conflict[course][i] == true)) return false;
        }
        return true;
    }
    public void tryValue(int k){
        if(k == n + 1){
        Map<Integer,Integer> cnt = new HashMap<>();
        Map<Integer,List<Integer>> result = new HashMap<>();
        for(int i = 1;i<= m;i++){
            List<Integer> list_result = new ArrayList<>();
            result.put(i, list_result);
        }
        for(int i=1; i<=n; i++){
           List<Integer> list_value = result.get(X[i]);
           list_value.add(i);
           result.put(X[i],list_value);
           
           int oldValue = cnt.get(X[i]) == null ? 0 : cnt.get(X[i]);
           cnt.put(X[i], oldValue + 1);
        }
            printSolution(result);
        int Min = 2147483647, Max = 0;
        for(Map.Entry<Integer,Integer> entry : cnt.entrySet()){
            Min = Math.min(Min, entry.getValue());
            Max = Math.max(Max,entry.getValue());
        }
        if(Max - Min < min_value){
            min_value = Max - Min;
            ans = Max;
        }
        return;
    }
        
        for(int i = 1;i<=m;i++){
          if(tearch[i][k] == true){
              if(check(i,k)){
                  X[k] = i;
                  tryValue(k +1);
                  X[k] = -1;
              }
          }
            
        }
    }
    
    public void printSolution(Map<Integer,List<Integer>> result){
        System.out.println("Các môn học sẽ được phân công như sau : ");
        for(Map.Entry<Integer,List<Integer>> entry : result.entrySet()){
            System.out.print("Courses assigned to teacher " + entry.getKey() + ": ");
            for(Integer course : entry.getValue()){
                System.out.print(course + ",");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    
    public static void main(String[] args) {
        BCAModel bcd = new BCAModel();
        bcd.loadData();
        bcd.tryValue(1);
        System.out.println(ans);
        
    }
    
    
}
