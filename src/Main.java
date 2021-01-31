public class Main {
    public static void main(String[] args) {
        int iteration = 0;
        double x = 5000*(Math.random() - 0.5), next_x;
        while(true){
            iteration++;
            next_x = nextRoot(x);
            if(Math.abs(x-next_x) <= 0.00001){
                System.out.println("Found a root: " + next_x + ". F(root) = " + (Math.pow(next_x,2) - 6*next_x + 3));
                break;
            }
            x = next_x;
            if(iteration >= 2000){
                System.out.println("Root not found");
                break;
            }
        }
    }

    static double nextRoot(double current){
        double f = Math.pow(current,2) - 6*current + 3;
        double f_prime = 2*current-6;
        return current - f/f_prime;
    }
}
