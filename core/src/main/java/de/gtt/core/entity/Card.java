package de.gtt.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "CARD")
public class Card implements Serializable {
	private String uuid;

	private Date created;
	private Date updated;

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

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "CREATED")
	@CreationTimestamp
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "UPDATED")
	@UpdateTimestamp
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Column(name = "UNIT")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "QUESTION_TEXT")
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Column(name = "QUESTION_EXAMPLE")
	public String getQuestionExample() {
		return questionExample;
	}

	public void setQuestionExample(String questionExample) {
		this.questionExample = questionExample;
	}

	@Column(name = "QUESTION_TRANS")
	public String getQuestionTranscription() {
		return questionTranscription;
	}

	public void setQuestionTranscription(String questionTranscription) {
		this.questionTranscription = questionTranscription;
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

	@Column(name = "ANSWER_TEXT")
	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Column(name = "ANSWER_EXAMPLE")
	public String getAnswerExample() {
		return answerExample;
	}

	public void setAnswerExample(String answerExample) {
		this.answerExample = answerExample;
	}

	@Column(name = "ANSWER_TRANS")
	public String getAnswerTranscription() {
		return answerTranscription;
	}

	public void setAnswerTranscription(String answerTranscription) {
		this.answerTranscription = answerTranscription;
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
}
