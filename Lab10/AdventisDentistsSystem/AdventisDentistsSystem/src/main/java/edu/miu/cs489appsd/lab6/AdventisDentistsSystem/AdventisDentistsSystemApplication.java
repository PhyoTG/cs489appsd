package edu.miu.cs489appsd.lab6.AdventisDentistsSystem;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.*;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AdventisDentistsSystemApplication implements CommandLineRunner {
	private final AppointmentService appointmentService;
	private final AddressService addressService;
	private final DentistService dentistService;
	private final PatientService patientService;
	private final SurgeryService surgeryService;

	public AdventisDentistsSystemApplication(AppointmentService appointmentService, AddressService addressService, DentistService dentistService, PatientService patientService, SurgeryService surgeryService) {
		this.appointmentService = appointmentService;
		this.addressService = addressService;
		this.dentistService = dentistService;
		this.patientService = patientService;
		this.surgeryService = surgeryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdventisDentistsSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is Persistance Layer for A Dental Services");
//		var address1 = addingNewAddress("1000 N 4th Street,Fairfield,IA", "52556-0001" );
//		var address2 = addingNewAddress("2000 N 14th Street,Fairfield,IA", "52556-0002" );
//		var address3 = addingNewAddress("3000 N 24th Street,Fairfield,IA", "52556-0003" );
//
//		var dentist1 = addingNewDentist("Tony", "Smith","641-000-0001","Cavity");
//		var dentist2 = addingNewDentist("Helen", "Pearson","641-000-0002","Beauty");
//		var dentist3 = addingNewDentist("Robin", "Plevin","641-000-0003","Whitening");
//
//		var patient100 = addingNewPatient("P100","Gillian", "White","641-000-0002", LocalDate.of(1990,12,21));
//		var patient105 = addingNewPatient("P105","Jin", "Bell","642-000-0002", LocalDate.of(1979,12,2));
//		var patient108 = addingNewPatient("P108","Ian", "McKay","643-000-0002", LocalDate.of(2000,1,21));
//		var patient110 = addingNewPatient("P100","John", "Walker","644-000-0002", LocalDate.of(1955,5,21));
//		patient100.setPatientAddress(address1);
//		patientService.updatePatient(patient100);
//		patient108.setPatientAddress(address2);
//		patientService.updatePatient(patient108);
//
//		var surgery15 = addingNewSurgery("S15","Fairfield Surgery","641-000-0000", address1);
//		var surgery10 = addingNewSurgery("S10","Ottumwa Surgery","641-001-0000", address2);
//		var surgery13 = addingNewSurgery("S13","Mount Pleasant Surgery","641-002-0000", address3);
//
//		addingNewAppointment(LocalDate.of(2013,9,12), "10:00", surgery15,patient100,dentist1);
//		addingNewAppointment(LocalDate.of(2013,9,12), "12:00", surgery15,patient105,dentist1);
//
//		addingNewAppointment(LocalDate.of(2013,9,12), "10:00", surgery10,patient108,dentist2);
//		addingNewAppointment(LocalDate.of(2013,9,14), "12:00", surgery10,patient108,dentist2);
//
//		addingNewAppointment(LocalDate.of(2013,9,14), "16:30", surgery15,patient105,dentist3);
//		addingNewAppointment(LocalDate.of(2013,9,15), "18:00", surgery13,patient110,dentist3);
//
//		List<Appointment> appointmentList = appointmentService.getAllAppointments();
//		appointmentList.forEach((appointment -> {
//			System.out.print(appointment.getDentist().getFirstname() +" "+ appointment.getDentist().getLastname());
//			System.out.print("| "+ appointment.getPatient().getPno());
//			System.out.print("| "+ appointment.getPatient().getFirstname() +" "+ appointment.getPatient().getLastname());
//			System.out.print("| "+ appointment.getDate() +" "+ appointment.getTime());
//			System.out.print("| "+ appointment.getSurgery().getSno());
//			System.out.println("");
//		}));
	}

	private Surgery addingNewSurgery(String id,String name, String phone, Address address) {
		var surgery = new Surgery(null,id,"Fairfield Surgery","641-000-0000", address);
		return surgeryService.addNewSurgery(surgery);
	}

	private Address addingNewAddress(String location, String zipCode) {
		var address = new Address(null,location, zipCode);
		return addressService.addNewAddress(address);
	}

	private Dentist addingNewDentist(String fname, String lname, String phone, String specialization) {
		var dentist = new Dentist(null,fname,lname,phone,specialization);
		return dentistService.addNewDentist(dentist);
	}

	private Patient addingNewPatient(String patientNumber,String fname, String lname, String phone, LocalDate dob) {
		var createpatient = new Patient(null,patientNumber,fname,lname,phone,dob);
		return patientService.addNewPatient(createpatient);
	}

	private Appointment addingNewAppointment(LocalDate date, String time,Surgery surgery,Patient patient, Dentist dentist) {
		var testAppointment = new Appointment(null,date,time,surgery,patient,dentist);
		return appointmentService.addNewAppointment(testAppointment);
	}
}
