--------------------------------------------------------
--  File created - Friday-December-13-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View AIS_VASSISTANT
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VASSISTANT" ("ASSISTANT_ID", "USER_ID", "USER_SURNAME", "USER_SURNAME_PY", "USER_APPELLATION", "USER_APPELLATION_PY", "SOUNDER_ID", "CREATE_TIME", "PARTITION_ID", "IS_VALID") AS 
  SELECT ASSISTANT_ID,
          USER_ID,
          USER_SURNAME,
          USER_SURNAME_PY,
          USER_APPELLATION,
          USER_APPELLATION_PY,
          SOUNDER_ID,
          CREATE_TIME,
          PARTITION_ID,
          IS_VALID
     FROM applyweb.AIS_TASSISTANT
;
--------------------------------------------------------
--  DDL for View AIS_VBLACKER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VBLACKER" ("TB_ID", "PHONE_NBR", "USER_ID", "CUSTOMER_ID", "CREATE_TIME", "PARTITION_ID", "VALID_STATE") AS 
  select "TB_ID","PHONE_NBR","USER_ID","CUSTOMER_ID","CREATE_TIME","PARTITION_ID","VALID_STATE" from applyweb.ais_tblacker
;
--------------------------------------------------------
--  DDL for View AIS_VNOTIFY
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VNOTIFY" ("TASKID", "MOBILE", "MESSAGE", "CREATE_TIME") AS 
  select "TASKID","MOBILE","MESSAGE","CREATE_TIME" from applyweb.ais_Tnotify
;
--------------------------------------------------------
--  DDL for View AIS_VORDERS_FLOW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VORDERS_FLOW" ("TCLT_ID", "USER_ID", "PHONE_NBR", "CUSTOMER_ID", "SERVICE_ID", "OPERATION_TYPE", "AREA_ID", "CONFIG_ID", "IS_WORKING", "SMS_TOTLE", "FIRST_ORDERTIME", "LAST_ORDERTIME", "PAUSE_ORDERTIME", "STOP_ORDERTIME", "PARTITION_ID") AS 
  SELECT TCLT_ID,
          USER_ID,
          PHONE_NBR,
          CUSTOMER_ID,
          SERVICE_ID,
          OPERATION_TYPE,
          AREA_ID,
          CONFIG_ID,
          CASE
             WHEN     IS_WORKING = 1
                  AND STOP_ORDERTIME > SYSDATE
                  AND PAUSE_ORDERTIME > SYSDATE
             THEN
                1
             ELSE
                0
          END
             IS_WORKING,
          SMS_TOTLE,
          FIRST_ORDERTIME,
          LAST_ORDERTIME,
          PAUSE_ORDERTIME,
          STOP_ORDERTIME,
          PARTITION_ID
     FROM applyweb.AIS_TORDERS
;
--------------------------------------------------------
--  DDL for View AIS_VUSER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VUSER" ("USER_ID", "CUSTOMER_ID", "PHONE_NBR", "MAIL", "WX_NBR", "OPERATION_TYPE", "AREA_ID", "CREATE_TIME", "PARTITION_ID") AS 
  SELECT USER_ID,
          CUSTOMER_ID,
          PHONE_NBR,
          MAIL,
          WX_NBR,
          OPERATION_TYPE,
          AREA_ID,
          CREATE_TIME,
          PARTITION_ID
     FROM applyweb.AIS_TUSER
;
--------------------------------------------------------
--  DDL for View AIS_VUSER_FLOW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VUSER_FLOW" ("USER_ID", "CUSTOMER_ID", "PHONE_NBR", "MAIL", "WX_NBR", "OPERATION_TYPE", "AREA_ID", "CREATE_TIME", "PARTITION_ID", "IS_TESTER") AS 
  SELECT USER_ID,
          CUSTOMER_ID,
          PHONE_NBR,
          MAIL,
          WX_NBR,
          OPERATION_TYPE,
          AREA_ID,
          CREATE_TIME,
          PARTITION_ID,
          is_tester
     FROM applyweb.AIS_TUSER where user_state=0
;
--------------------------------------------------------
--  DDL for View AIS_VUSERDIY
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VUSERDIY" ("USERDIY_ID", "USER_ID", "CONTENT_TYPE", "CONTENT_DETAIL", "FILE_PATH", "FILE_NAME", "STATE", "CREATE_TIME", "PARTITION_ID") AS 
  SELECT USERDIY_ID,
          USER_ID,
          CONTENT_TYPE,
          CONTENT_DETAIL,
          FILE_PATH,
          FILE_NAME,
          STATE,
          CREATE_TIME,
          PARTITION_ID
     FROM applyweb.AIS_TUSERDIY
;
--------------------------------------------------------
--  DDL for View AIS_VUSERDIY_CLASS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "AIS_VUSERDIY_CLASS" ("CONTENT_TYPE", "CONTENT_NAME", "CONTENT_REMARK") AS 
  SELECT 1 CONTENT_TYPE, 'BEGIN' CONTENT_NAME, '开场白音' CONTENT_REMARK
     FROM DUAL
   UNION ALL
   SELECT 2 CONTENT_TYPE,
          'CONTINUE' CONTENT_NAME,
          '转秘书接听引导音' CONTENT_REMARK
     FROM DUAL
   UNION ALL
   SELECT 3 CONTENT_TYPE, 'END' CONTENT_NAME, '结束语音' CONTENT_REMARK
     FROM DUAL
;
--------------------------------------------------------
--  DDL for Synonymn PKG_CALLIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "PKG_CALLIN" FOR "PKG_CALLIN";
--------------------------------------------------------
--  DDL for Synonymn TYPE_CALLIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "TYPE_CALLIN" FOR "TYPE_CALLIN";





--     create or replace trigger tr_ais_sms_receivecontent
--     before insert on ais_sms_receivecontent
--     for each row
--     begin
--     select seq_ais_sms_receivecontent.nextval into:new.id from sys.dual;
--     end;