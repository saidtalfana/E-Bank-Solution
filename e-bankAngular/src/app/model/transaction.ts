import { Time } from "@angular/common";


export class Transaction{
    transactionID: number | undefined;
    transactionDate: Date | undefined;
    time: Time | undefined;
    amount: number | undefined;
    transactionType: TransactionType | undefined;
    statuTransaction: StatuTransaction | undefined;
    description: string | undefined;
    
    
}