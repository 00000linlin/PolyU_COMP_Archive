public enum BinaryOperator {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");
    private final String symbol;

    BinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public int calculate(Operand left, Operand right){
        int result=0;
        if (left != null && right != null){
            switch (this){
                case ADD:
                    result= left.evaluate() + right.evaluate();
                    break;
                case SUB:
                    result= left.evaluate() - right.evaluate();
                    break;
                case MUL:
                    result= left.evaluate() * right.evaluate();
                    break;
                case DIV:
                    if (right.evaluate() != 0) {
                        result = left.evaluate() / right.evaluate();
                    }
                    break;
                default:
                    System.exit(1);
            }
        }
        else{
            System.exit(1);
        }
        return result;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String toString(){
        return getSymbol();
    }

    public static BinaryOperator fromString(String symbol){
        for(BinaryOperator operator: BinaryOperator.values()){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        System.exit(1);
        return null;
    }
}

