/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package searchbitonic;

import java.util.Scanner;

/**
 *
 * @author tuan0
 */
public class SearchBitonic {
    
    public static int ascendBinarySearch(int a[], int l, int r, int key) {
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(a[mid] == key) return mid;
            else if(a[mid] > key) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    } 
    
    public static int decendBinarySearch(int a[], int l, int r, int key) {
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(a[mid] == key) return mid;
            else if(a[mid] > key) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    public static int findBitonicPoint(int a[], int l, int r) {
        int bitonicPoint = 0;
        int mid;
        mid = (l +r)/2;
        if(a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
        else {
            if(a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                bitonicPoint = findBitonicPoint(a, mid, r);
            }
            else {
                if (a[mid] < a[mid - 1]
                    && a[mid] > a[mid + 1])
                {
                    bitonicPoint = findBitonicPoint(a, l, mid);
                }
            }
           
        }
        return bitonicPoint;
    }
    public static int searchBitonic(int a[], int n, int key, int index) {
        if(a[index] == key) return index;
        else if( key > a[index]) return -1;
        else {
            int tmp = ascendBinarySearch(a, 0, index, key);
            if(tmp != -1) return tmp;
            return decendBinarySearch(a, index, n -1, key);
        }
    }

    
    public static void main(String[] args) {
        int a[] = {-8, 1, 2, 3, 4, 5, -2, -3};
                
        int key;
        Scanner sc = new Scanner(System.in);
        key = sc.nextInt();
        int n, l, r;
        n = a.length;
        l = 0;
        r = n - 1;
        int index = findBitonicPoint(a, l, r);
        
        int x = searchBitonic(a, n, key, index);
        
        if(x == -1) {
            System.out.println("Can not find the element");
        }
        else {
            System.out.printf("Phần tử cần tìm là: %d\n", x);
        }
        
        
    }
    
}
