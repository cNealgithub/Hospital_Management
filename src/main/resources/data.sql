INSERT INTO `springboot`.`patients` (`age`, `date_of_birth`, `id`, `insurance_id`, `blood_group`, `gender`, `name`) VALUES
(28, '1997-03-15', 1, NULL, 'A+', 'Male', 'Ravi Kumar'),
(34, '1991-07-22', 2, NULL, 'B-', 'Female', 'Anita Sharma'),
(45, '1980-11-05', 3, NULL, 'O+', 'Male', 'Suresh Mehta'),
(52, '1973-01-30', 4, NULL, 'AB+', 'Female', 'Geeta Verma'),
(19, '2006-06-12', 5, NULL, 'A-', 'Male', 'Aman Singh'),
(60, '1965-09-18', 6, NULL, 'B+', 'Female', 'Kamla Devi'),
(31, '1994-12-03', 7, NULL, 'O-', 'Male', 'Nikhil Joshi'),
(26, '1999-04-25', 8, NULL, 'AB-', 'Female', 'Priya Das'),
(38, '1987-08-09', 9, NULL, 'A+', 'Male', 'Rahul Chauhan'),
(23, '2002-02-17', 10, NULL, 'B+', 'Female', 'Sneha Reddy');

INSERT INTO `springboot`.`doctor` (`email`, `name`, `specialization`) VALUES
('dr.rkumar@hospital.com', 'Dr. Ramesh Kumar', 'Cardiology'),
('anita.s@clinic.org', 'Dr. Anita Sinha', 'Pediatrics'),
('mehta.s@medicare.in', 'Dr. Suresh Mehta', 'Orthopedics'),
('geeta.v@healthcare.net', 'Dr. Geeta Verma', 'Dermatology');