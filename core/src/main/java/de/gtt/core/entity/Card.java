package de.gtt.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CARD")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
		@NamedQuery(
				name = "findByUUID",
				query = "SELECT card FROM de.gtt.core.entity.Card card WHERE card.uuid = :uuid"),
		@NamedQuery(
				name = "findAll",
				query = "SELECT card FROM de.gtt.core.entity.Card card ORDER BY card.position"),
		@NamedQuery(
				name = "deleteByUUID",
				query = "DELETE FROM de.gtt.core.entity.Card card WHERE card.uuid = :uuid"),
		@NamedQuery(
				name = "deleteAll",
				query = "DELETE FROM de.gtt.core.entity.Card")
})
public class Card implements Serializable {
	private String uuid;

	private Date created;
	private Date updated;
	private Date published;

	private long position;

	private String unit;

	private String questionText;
	private String questionExample;
	private String questionTranscription;
	private String questionImage1;
	private String questionImage2;
	private String questionImage3;
	private String questionAudio1;
	private String questionAudio2;
	private String questionAudio3;

	private String answerText;
	private String answerExample;
	private String answerTranscription;
	private String answerImage1;
	private String answerImage2;
	private String answerImage3;
	private String answerAudio1;
	private String answerAudio2;
	private String answerAudio3;

	public Card() {
		this.uuid = UUID.randomUUID().toString();
	}

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	public String getUuid() {
		return uuid;
	}

	protected void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "CREATED")
	public Date getCreated() {
		return created;
	}

	protected void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "UPDATED")
	public Date getUpdated() {
		return updated;
	}

	protected void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Column(name = "PUBLISHED")
	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	@Column(name = "POSITION")
	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public Card withPosition(long position) {
		this.position = position;
		return this;
	}

	@Column(name = "UNIT")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Card withUnit(String unit) {
		this.unit = unit;
		return this;
	}

	@Column(name = "QUESTION_TEXT")
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Card withQuestionText(String questionText) {
		this.questionText = questionText;
		return this;
	}

	@Column(name = "QUESTION_EXAMPLE")
	public String getQuestionExample() {
		return questionExample;
	}

	public void setQuestionExample(String questionExample) {
		this.questionExample = questionExample;
	}

	public Card withQuestionExample(String questionExample) {
		this.questionExample = questionExample;
		return this;
	}

	@Column(name = "QUESTION_TRANS")
	public String getQuestionTranscription() {
		return questionTranscription;
	}

	public void setQuestionTranscription(String questionTranscription) {
		this.questionTranscription = questionTranscription;
	}

	public Card withQuestionTranscription(String questionTranscription) {
		this.questionTranscription = questionTranscription;
		return this;
	}

	@Column(name = "QUESTION_IMG1")
	public String getQuestionImage1() {
		return questionImage1;
	}

	public void setQuestionImage1(String questionImage1) {
		this.questionImage1 = questionImage1;
	}

	@Column(name = "QUESTION_IMG2")
	public String getQuestionImage2() {
		return questionImage2;
	}

	public void setQuestionImage2(String questionImage2) {
		this.questionImage2 = questionImage2;
	}

	@Column(name = "QUESTION_IMG3")
	public String getQuestionImage3() {
		return questionImage3;
	}

	public void setQuestionImage3(String questionImage3) {
		this.questionImage3 = questionImage3;
	}

	public Card withQuestionImage(String questionImage) {
		if (this.questionImage1 == null) {
			this.questionImage1 = questionImage;
		}
		else if (this.questionImage2 == null) {
			this.questionImage2 = questionImage;
		}
		else if (this.questionImage3 == null) {
			this.questionImage3 = questionImage;
		}
		else {
			throw new IllegalStateException("No question image can be added since there's no free slot anymore.");
		}

		return this;
	}

	@Column(name = "QUESTION_AUDIO1")
	public String getQuestionAudio1() {
		return questionAudio1;
	}

	public void setQuestionAudio1(String questionAudio1) {
		this.questionAudio1 = questionAudio1;
	}

	@Column(name = "QUESTION_AUDIO2")
	public String getQuestionAudio2() {
		return questionAudio2;
	}

	public void setQuestionAudio2(String questionAudio2) {
		this.questionAudio2 = questionAudio2;
	}

	@Column(name = "QUESTION_AUDIO3")
	public String getQuestionAudio3() {
		return questionAudio3;
	}

	public void setQuestionAudio3(String questionAudio3) {
		this.questionAudio3 = questionAudio3;
	}

	public Card withQuestionAudio(String questionAudio) {
		if (this.questionAudio1 == null) {
			this.questionAudio1 = questionAudio;
		}
		else if (this.questionAudio2 == null) {
			this.questionAudio2 = questionAudio;
		}
		else if (this.questionAudio3 == null) {
			this.questionAudio3 = questionAudio;
		}
		else {
			throw new IllegalStateException("No question audio can be added since there's no free slot anymore.");
		}

		return this;
	}

	@Column(name = "ANSWER_TEXT")
	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Card withAnswerText(String answerText) {
		this.answerText = answerText;
		return this;
	}

	@Column(name = "ANSWER_EXAMPLE")
	public String getAnswerExample() {
		return answerExample;
	}

	public void setAnswerExample(String answerExample) {
		this.answerExample = answerExample;
	}

	public Card withAnswerExample(String answerExample) {
		this.answerExample = answerExample;
		return this;
	}

	@Column(name = "ANSWER_TRANS")
	public String getAnswerTranscription() {
		return answerTranscription;
	}

	public void setAnswerTranscription(String answerTranscription) {
		this.answerTranscription = answerTranscription;
	}

	public Card withAnswerTranscription(String answerTranscription) {
		this.answerTranscription = answerTranscription;
		return this;
	}

	@Column(name = "ANSWER_IMG1")
	public String getAnswerImage1() {
		return answerImage1;
	}

	public void setAnswerImage1(String answerImage1) {
		this.answerImage1 = answerImage1;
	}

	@Column(name = "ANSWER_IMG2")
	public String getAnswerImage2() {
		return answerImage2;
	}

	public void setAnswerImage2(String answerImage2) {
		this.answerImage2 = answerImage2;
	}

	@Column(name = "ANSWER_IMG3")
	public String getAnswerImage3() {
		return answerImage3;
	}

	public void setAnswerImage3(String answerImage3) {
		this.answerImage3 = answerImage3;
	}

	public Card withAnswerImage(String answerImage) {
		if (this.answerImage1 == null) {
			this.answerImage1 = answerImage;
		}
		else if (this.answerImage2 == null) {
			this.answerImage2 = answerImage;
		}
		else if (this.answerImage3 == null) {
			this.answerImage3 = answerImage;
		}
		else {
			throw new IllegalStateException("No answer image can be added since there's no free slot anymore.");
		}

		return this;
	}

	@Column(name = "ANSWER_AUDIO1")
	public String getAnswerAudio1() {
		return answerAudio1;
	}

	public void setAnswerAudio1(String answerAudio1) {
		this.answerAudio1 = answerAudio1;
	}

	@Column(name = "ANSWER_AUDIO2")
	public String getAnswerAudio2() {
		return answerAudio2;
	}

	public void setAnswerAudio2(String answerAudio2) {
		this.answerAudio2 = answerAudio2;
	}

	@Column(name = "ANSWER_AUDIO3")
	public String getAnswerAudio3() {
		return answerAudio3;
	}

	public void setAnswerAudio3(String answerAudio3) {
		this.answerAudio3 = answerAudio3;
	}

	public Card withAnswerAudio(String answerAudio) {
		if (this.answerAudio1 == null) {
			this.answerAudio1 = answerAudio;
		}
		else if (this.answerAudio2 == null) {
			this.answerAudio2 = answerAudio;
		}
		else if (this.answerAudio3 == null) {
			this.answerAudio3 = answerAudio;
		}
		else {
			throw new IllegalStateException("No answer audio can be added since there's no free slot anymore.");
		}

		return this;
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Card card = (Card) o;

		return uuid != null ? uuid.equals(card.uuid) : card.uuid == null;
	}

	@Override
	public int hashCode() {
		return uuid != null ? uuid.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Card{" +
				"position='" + position + '\'' +
				", uuid='" + uuid + '\'' +
				", created=" + created +
				", updated=" + updated +
				", published=" + published +
				", unit='" + unit + '\'' +
				", questionText='" + questionText + '\'' +
				", questionExample='" + questionExample + '\'' +
				", questionTranscription='" + questionTranscription + '\'' +
				", questionImage1='" + questionImage1 + '\'' +
				", questionImage2='" + questionImage2 + '\'' +
				", questionImage3='" + questionImage3 + '\'' +
				", questionAudio1='" + questionAudio1 + '\'' +
				", questionAudio2='" + questionAudio2 + '\'' +
				", questionAudio3='" + questionAudio3 + '\'' +
				", answerText='" + answerText + '\'' +
				", answerExample='" + answerExample + '\'' +
				", answerTranscription='" + answerTranscription + '\'' +
				", answerImage1='" + answerImage1 + '\'' +
				", answerImage2='" + answerImage2 + '\'' +
				", answerImage3='" + answerImage3 + '\'' +
				", answerAudio1='" + answerAudio1 + '\'' +
				", answerAudio2='" + answerAudio2 + '\'' +
				", answerAudio3='" + answerAudio3 + '\'' +
				'}';
	}
}
