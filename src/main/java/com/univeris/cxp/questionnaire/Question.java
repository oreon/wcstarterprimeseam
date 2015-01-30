package com.univeris.cxp.questionnaire;

import javax.persistence.*;
import org.witchcraft.base.entity.FileAttachment;
import org.witchcraft.base.entity.BaseEntity;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

import javax.validation.constraints.*;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * This file is an Entity Class generated by Witchcraftmda.
 * DO NOT MODIFY any changes will be overwritten with the next run of the code generator.
 */

@Entity
@Table(name = "question")
@Filters({@Filter(name = "archiveFilterDef"), @Filter(name = "tenantFilterDef")})
public class Question extends QuestionBase implements java.io.Serializable {
	private static final long serialVersionUID = 575052829L;
}
