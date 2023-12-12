class diffie{
    public static void main(String[] args){
        int p=3,q=11,a=7,b=9;
        System.out.println("The values of p and q :"+p+"and "+q+"");
        double y1=(Math.pow(p,a))%q;
        double y2=(Math.pow(q,b))%q;
        System.out.println("y1 is "+y1);
        System.out.println("y2 is "+y2);    
        double k1=(Math.pow(y2,a))%q;
        double k2=(Math.pow(k1,b))%q;
        System.out.println("The value of k1 and k2:"+k1+" and "+k2+"");
        if(k1==k2){
            System.out.println("The key exchange is success");
        }
        else {
            System.out.println("The key exchange failed");
        }
        }
    }