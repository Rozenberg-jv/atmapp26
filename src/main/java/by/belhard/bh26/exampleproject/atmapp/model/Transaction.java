package by.belhard.bh26.exampleproject.atmapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int id;
    private Account sender;
    private Account receiver;
    private LocalDateTime time;
    private int amount;

    public TransactionBuilder builder() {
        return new TransactionBuilder();
    }

    public class TransactionBuilder {

        private Transaction transaction = new Transaction();

        public TransactionBuilder id(int id) {
            transaction.setId(id);
            return this;
        }

        public TransactionBuilder sender(Account sender) {
            transaction.setSender(sender);
            return this;
        }

        public TransactionBuilder receiver(Account receiver) {
            transaction.setReceiver(receiver);
            return this;
        }

        public TransactionBuilder time(LocalDateTime time) {
            transaction.setTime(time);
            return this;
        }

        public TransactionBuilder amount(int amount) {
            transaction.setAmount(amount);
            return this;
        }

        public Transaction build() {
            return transaction;
        }
    }
}
