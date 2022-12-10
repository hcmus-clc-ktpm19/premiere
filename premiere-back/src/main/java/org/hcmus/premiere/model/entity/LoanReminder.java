package org.hcmus.premiere.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;
import org.hcmus.premiere.model.enums.LoanStatus;

@Entity
@Table(name = "loan_reminder", schema = "premiere")
@Data
public class LoanReminder extends PremiereAbstractEntity {

  @Basic
  @Column(name = "loan_balance", nullable = false, columnDefinition = "NUMERIC")
  private BigDecimal loanBalance;

  @Basic
  @Column(name = "status", nullable = false, columnDefinition = "LOAN_STATUS")
  @Enumerated(EnumType.STRING)
  private LoanStatus status;

  @Basic
  @Column(name = "time", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime time;

  @Basic
  @Column(name = "loan_remark", nullable = false, columnDefinition = "VARCHAR(255)")
  private String loanRemark;

  @ManyToOne
  @JoinColumn(name = "sender_credit_card_id", referencedColumnName = "id", nullable = false)
  private CreditCard senderCreditCard;

  @ManyToOne
  @JoinColumn(name = "receiver_credit_card_id", referencedColumnName = "id", nullable = false)
  private CreditCard receiverCreditCard;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoanReminder that = (LoanReminder) o;
    return Objects.equals(id, that.id)
        && Objects.equals(
        version, that.version)
        && Objects.equals(loanBalance, that.loanBalance) && Objects.equals(status,
        that.status) && Objects.equals(time, that.time) && Objects.equals(
        loanRemark, that.loanRemark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, loanBalance, status, time,
        loanRemark, version);
  }
}
