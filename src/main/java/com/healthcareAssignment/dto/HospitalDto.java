package com.healthcareAssignment.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import com.healthcareAssignment.Individualentity.ExaminationnewEntity;
import com.healthcareAssignment.Individualentity.HospitalnewEntity;
import com.healthcareAssignment.Individualentity.PatientnewEntity;
import com.healthcareAssignment.entity.Examination;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.entity.Patient;
import com.healthcareAssignment.individualmodels.ExaminationnewModel;
import com.healthcareAssignment.individualmodels.HospitalnewModel;
import com.healthcareAssignment.individualmodels.PatientnewModel;
import com.healthcareAssignment.models.ExaminationModel;
import com.healthcareAssignment.models.HospitalModel;
import com.healthcareAssignment.models.PatientModel;

public class HospitalDto {

	public static Hospital hospitalModelToEntity(HospitalModel objHospitalModel) {
		Hospital objHospital = new Hospital();

		try {

			if (objHospitalModel.getId() != null) {
				objHospital.setId(objHospitalModel.getId());
			}
			objHospital.setHospital_Name(objHospitalModel.getHospital_Name());
			objHospital.setDescription(objHospitalModel.getDescription());
			List<Patient> patient = new ArrayList<>();
			for (PatientModel objPatient : objHospitalModel.getPatient()) {
				Patient objLocPatient = new Patient();
				objLocPatient.setPatient_id(objPatient.getPatient_id());
				objLocPatient.setDateOfBirth(stringToDate(objPatient.getDateOfBirth(), "yyyy-MM-dd HH:mm:ss"));
				objLocPatient.setGender(objPatient.getGender());

				objLocPatient.setPatient_Name(objPatient.getPatient_Name());
				objLocPatient.setAge(ageCal(objLocPatient.getDateOfBirth()));
				objLocPatient.setGenerateDate(new Date());

				objLocPatient.setHospital(objHospital);
				patient.add(objLocPatient);

				List<Examination> examinationList = new ArrayList<>();
				for (ExaminationModel objExamination : objPatient.getExmination()) {
					Examination objLocExamination = new Examination();
					objLocExamination.setEx_id(objExamination.getEx_id());
					objLocExamination.setEx_name(objExamination.getEx_name());
					objLocExamination.setEx_Description(objExamination.getEx_Description());
					objLocExamination.setExamDate(stringToDate(objExamination.getExamDate(), "yyyy-MM-dd HH:mm:ss"));

					objLocExamination.setPatient(objLocPatient);
					examinationList.add(objLocExamination);
				}

				objLocPatient.setExamination(examinationList);

			}
			objHospital.setPatient(patient);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objHospital;
	}

	public static Date stringToDate(String dateString, String dateFormat) {
		Date date = null;
		try {
			if (dateString != null && !"".equals(dateString)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				date = sdf.parse(dateString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String ageCal(Date date) {

		Calendar birthDay = Calendar.getInstance();
		birthDay.setTimeInMillis(date.getTime());
		int birthYear = birthDay.get(Calendar.YEAR);
		int birthMonth = birthDay.get(Calendar.MONTH) + 1;
		int birthDate = birthDay.get(Calendar.DAY_OF_MONTH);
		LocalDate birthdate = new LocalDate(birthYear, birthMonth, birthDate); // Birth
																				// date
		LocalDate now = new LocalDate(); // Today's date

		Period period = new Period(birthdate, now, PeriodType.yearMonthDay());

		// Now access the values as below
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());
		return String.valueOf(period.getYears());
	}

	public static HospitalnewEntity newhospitalModelToEntity(HospitalnewModel objHospitalModel) {
		HospitalnewEntity objHospital = new HospitalnewEntity();

		try {

			if (objHospitalModel.getId() != null) {
				objHospital.setId(objHospitalModel.getId());
			}
			objHospital.setHospital_Name(objHospitalModel.getHospital_Name());
			objHospital.setDescription(objHospitalModel.getDescription());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objHospital;
	}

	public static PatientnewEntity newpatientModelToEntity(PatientnewModel objPatientnewModel) {
		PatientnewEntity objPatientnewEntity = new PatientnewEntity();

		try {

			if (objPatientnewModel.getPatient_id() != null) {
				objPatientnewEntity.setPatient_id(objPatientnewModel.getPatient_id());
			}

			objPatientnewEntity
					.setDateOfBirth(stringToDate(objPatientnewModel.getDateOfBirth(), "yyyy-MM-dd HH:mm:ss"));
			objPatientnewEntity.setGender(objPatientnewModel.getGender());

			objPatientnewEntity.setPatient_Name(objPatientnewModel.getPatient_Name());
			objPatientnewEntity.setAge(ageCal(objPatientnewEntity.getDateOfBirth()));
			objPatientnewEntity.setGenerateDate(new Date());
			
			HospitalnewEntity objHospital = new HospitalnewEntity();
			objHospital.setId(objPatientnewModel.getHospitalId());
			
			objPatientnewEntity.setHospital(objHospital);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objPatientnewEntity;
	}
	
	
	public static ExaminationnewEntity newExamiModelToEntity(ExaminationnewModel objExaminationnewModel) {
		ExaminationnewEntity objExaminationnewEntity = new ExaminationnewEntity();

		try {

			if (objExaminationnewModel.getEx_id() != null) {
				objExaminationnewEntity.setEx_id(objExaminationnewModel.getEx_id());
			}
			objExaminationnewEntity.setEx_name(objExaminationnewModel.getEx_name());
			objExaminationnewEntity.setEx_Description(objExaminationnewModel.getEx_Description());
			objExaminationnewEntity.setExamDate(stringToDate(objExaminationnewModel.getExamDate(), "yyyy-MM-dd HH:mm:ss"));
			
			HospitalnewEntity objHospital = new HospitalnewEntity();
			objHospital.setId(objExaminationnewModel.getHospitalId());
			PatientnewEntity objPatientnewEntity = new PatientnewEntity();
			objPatientnewEntity.setPatient_id(objExaminationnewModel.getPatientId());
			objExaminationnewEntity.setHospital(objHospital);
			objExaminationnewEntity.setPatient(objPatientnewEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objExaminationnewEntity;
	}

}
