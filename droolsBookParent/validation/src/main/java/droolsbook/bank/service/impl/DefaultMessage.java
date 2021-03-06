/**
 * 
 */
package droolsbook.bank.service.impl;

import java.io.Serializable;
import java.util.List;

import droolsbook.bank.service.Message;

/**
 * @author miba
 * 
 */
// @extract-start 03 54
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
//... other imports

public class DefaultMessage implements Message, Serializable {
  private Message.Type type;
  private String messageKey;
  private List<Object> context;

  public DefaultMessage(Message.Type type, String messageKey,
      List<Object> context) {
    if (type == null || messageKey == null) {
      throw new IllegalArgumentException(
          "Type and messageKey cannot be null");
    }
    this.type = type;
    this.messageKey = messageKey;
    this.context = context;
  }
  
  public String getMessageKey() {
    return messageKey;
  }
  
  public Message.Type getType() {
    return type;
  }
  
  public List<Object> getContextOrdered() {    
    return context;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other)
      return true;
    if (!(other instanceof DefaultMessage))
      return false;
    DefaultMessage castOther = (DefaultMessage) other;
    return new EqualsBuilder().append(type, castOther.type)
        .append(messageKey, castOther.messageKey).append(
            context, castOther.context).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(98587969, 810426655).append(
        type).append(messageKey).append(context).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("type", type)
        .append("messageKey", messageKey).append("context",
            context).toString();
  }
}
// @extract-end