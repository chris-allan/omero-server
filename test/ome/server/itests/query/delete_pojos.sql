begin;
delete from imageannotation where id between 3000 and 3999;
delete from datasetannotation where id between 4000 and 4999;
delete from datasetimagelink where id between 6000 and 6999;
delete from categoryimagelink where id between 6000 and 6999;
delete from projectdatasetlink where id between 8000 and 8999;
delete from categorygroupcategorylink where id between 8000 and 8999;
delete from image where id between 5000 and 5999;
delete from dataset where id between 7000 and 7999;
delete from category where id between 7000 and 7999;
delete from project where id between 9000 and 9999;
delete from categorygroup where id between 9000 and 9999;
delete from groupexperimentermap where id = 10000;
delete from experimentergroup where id = 10000;
delete from experimenter where id = 10000;
commit;
