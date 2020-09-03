
curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,202 INFO 19774 [1378892319440940/10.50.20.66/-/139ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes [138ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=VisitRecord&busiTypeId=654436666310684' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,354 INFO 19774 [1378892319440940/10.50.20.66/-/291ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=VisitRecord&busiTypeId=654436666310684 [148ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/metamodels/xObjectUIConfig/filter?apiKey=VisitRecord' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,420 INFO 19774 [1378892319440940/10.50.20.66/-/357ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/metamodels/xObjectUIConfig/filter?apiKey=VisitRecord [63ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,491 INFO 19774 [1378892319440940/10.50.20.66/-/428ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord [70ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/itemDependencies/itemItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,561 INFO 19774 [1378892319440940/10.50.20.66/-/498ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/itemDependencies/itemItems [129ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/settings/systemSettings/currencies' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,565 INFO 19774 [1378892319440940/10.50.20.66/-/502ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/settings/systemSettings/currencies [140ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items/referfilters' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,602 INFO 19774 [1378892319440940/10.50.20.66/-/539ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items/referfilters [135ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/pickOptions' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,605 INFO 19774 [1378892319440940/10.50.20.66/-/542ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/pickOptions [175ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,610 INFO 19774 [1378892319440940/10.50.20.66/-/547ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes [185ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items/joinItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,648 INFO 19774 [1378892319440940/10.50.20.66/-/585ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items/joinItems [182ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=VisitRecord' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,657 INFO 19774 [1378892319440940/10.50.20.66/-/594ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=VisitRecord [222ms] RES:{"code":"200","msg":"success","errorInfo":""}

curl -X POST 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/xobjects/dimDepart/actions/getChild' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"belongId":406}'

2020-09-03 14:06:08,672 INFO 19774 [1378892319440940/10.50.20.66/-/609ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [POST]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/xobjects/dimDepart/actions/getChild [168ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/objectLinks/parentLinks' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,694 INFO 19774 [1378892319440940/10.50.20.66/-/631ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/objectLinks/parentLinks [80ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/json/crm_approval/check-approval.action?belongId=406&entityTypeId=654436666310684' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,721 INFO 19774 [1378892319440940/10.50.20.66/-/658ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/json/crm_approval/check-approval.action?belongId=406&entityTypeId=654436666310684 [109ms] RES:{}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,766 INFO 19774 [1378892319440940/10.50.20.66/-/703ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/items [332ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/privacies/customEntity21__c/functionPermissions' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,782 INFO 19774 [1378892319440940/10.50.20.66/-/719ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/privacies/customEntity21__c/functionPermissions [65ms] RES:{"scode":"0"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/privacies/customEntity28__c/functionPermissions' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,791 INFO 19774 [1378892319440940/10.50.20.66/-/728ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/privacies/customEntity28__c/functionPermissions [73ms] RES:{"scode":"0"}

curl -X POST 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/xobjects/dimDepart/actions/getDesendent' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"departId":636704454459412,"belongId":406}'

2020-09-03 14:06:08,828 INFO 19774 [1378892319440940/10.50.20.66/-/765ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [POST]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/xobjects/dimDepart/actions/getDesendent [130ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items/referfilters' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,858 INFO 19774 [1378892319440940/10.50.20.66/-/795ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items/referfilters [68ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items/joinItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,866 INFO 19774 [1378892319440940/10.50.20.66/-/803ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items/joinItems [80ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=customEntity21__c' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,869 INFO 19774 [1378892319440940/10.50.20.66/-/806ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=customEntity21__c [82ms] RES:{"code":"200","msg":"success","errorInfo":""}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=customEntity28__c' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,881 INFO 19774 [1378892319440940/10.50.20.66/-/818ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/uiextensions/items?xobjectApiKey=customEntity28__c [78ms] RES:{"code":"200","msg":"success","errorInfo":""}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items/joinItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,883 INFO 19774 [1378892319440940/10.50.20.66/-/820ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items/joinItems [86ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,898 INFO 19774 [1378892319440940/10.50.20.66/-/835ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/items [109ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,904 INFO 19774 [1378892319440940/10.50.20.66/-/841ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items [105ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=VisitRecord&busiTypeId=654436666310684' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,910 INFO 19774 [1378892319440940/10.50.20.66/-/847ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=VisitRecord&busiTypeId=654436666310684 [133ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items/referfilters' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:08,953 INFO 19774 [1378892319440940/10.50.20.66/-/890ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/items/referfilters [140ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X POST 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/VisitRecord/actions/defaultValues' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"itemApiKeyList":["name","entityType","ownerId","dimDepart","dimProduct","dimIndustry","dimBusiness","createdBy","createdAt","doorPicture","updatedBy","updatedAt","lockStatus","signInDate","signInStatus","signOutDate","signOutStatus","signOutAddress","signInAddress","schedule","visitTime","longitude","latitude","visitType","visitDetailId","compVisitObject_data","compVisitObject","visitModel","customItem2__c","customItem3__c","customItem4__c","customItem5__c","customItem6__c","customItem7__c","customItem8__c","customItem9__c","customItem10__c","customItem11__c","customItem12__c","customItem14__c","customItem15__c","customItem16__c","customItem17__c","customItem18__c","customItem20__c","customItem21__c","customItem23__c","customItem27__c","customItem28__c","customItem29__c","customItem30__c","customItem31__c","customItem32__c","customItem33__c","customItem34__c","customItem35__c","customItem36__c","customItem37__c","customItem38__c","customItem39__c","customItem40__c","customItem41__c","customItem42__c","customItem43__c","customItem44__c"]}'

2020-09-03 14:06:09,020 INFO 19774 [1378892319440940/10.50.20.66/-/957ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [POST]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/VisitRecord/actions/defaultValues [59ms] RES:{"code":"200","msg":"OK"}
[长度：]65

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/customEntity21__c/654436666310684/childMappings' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,057 INFO 19774 [1378892319440940/10.50.20.66/-/994ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/customEntity21__c/654436666310684/childMappings [156ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/customEntity28__c/654436666310684/childMappings' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,091 INFO 19774 [1378892319440940/10.50.20.66/-/1028ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/VisitRecord/busiTypes/customEntity28__c/654436666310684/childMappings [101ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=customEntity21__c&busiTypeId=1289764801363978' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,163 INFO 19774 [1378892319440940/10.50.20.66/-/1099ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=customEntity21__c&busiTypeId=1289764801363978 [102ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=customEntity28__c&busiTypeId=1333670372802573' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,206 INFO 19774 [1378892319440940/10.50.20.66/-/1142ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/layouts/createForms?xobjectApiKey=customEntity28__c&busiTypeId=1333670372802573 [105ms] RES:{"code":"200","msg":"OK"}

curl -X POST 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/customEntity21__c/actions/defaultValues' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"itemApiKeyList":["name","entityType","dimDepart","dimProduct","workflowStageName","dimIndustry","dimBusiness","createdBy","applicantId","createdAt","updatedBy","updatedAt","lockStatus","approvalStatus","customItem1__c","customItem2__c"]}'

2020-09-03 14:06:09,230 INFO 19774 [1378892319440940/10.50.20.66/-/1167ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [POST]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/customEntity21__c/actions/defaultValues [56ms] RES:{"code":"200","msg":"OK"}

curl -X POST 'https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/customEntity28__c/actions/defaultValues' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"itemApiKeyList":["name","entityType","dimDepart","dimProduct","workflowStageName","dimIndustry","dimBusiness","createdBy","applicantId","createdAt","updatedBy","updatedAt","lockStatus","approvalStatus","customItem1__c","customItem2__c","customItem3__c"]}'

2020-09-03 14:06:09,280 INFO 19774 [1378892319440940/10.50.20.66/-/1217ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [POST]https://crm-citest.xiaoshouyi.com/rest/data/v2.0/compute/customEntity28__c/actions/defaultValues [71ms] RES:{"code":"200","msg":"OK"}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/itemDependencies/itemItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,292 INFO 19774 [1378892319440940/10.50.20.66/-/1229ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/itemDependencies/itemItems [59ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/itemDependencies/itemItems' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,340 INFO 19774 [1378892319440940/10.50.20.66/-/1277ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/itemDependencies/itemItems [50ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/busiTypes/pickOptions' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,354 INFO 19774 [1378892319440940/10.50.20.66/-/1291ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity21__c/busiTypes/pickOptions [52ms] RES:{"code":"0","msg":null,"errorInfo":null}

curl -X GET 'https://crm-citest.xiaoshouyi.com/mobile/visit-template/get-template.action' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432' \
--data '{"source":"1","appType":"0","tmplId":"1091773901340709","cache_key":"1378892319440940","_vs":"2007.0.4","os":"23","model":"Android MuMu","objectId":"1368790948429862"}'

2020-09-03 14:06:09,374 INFO 19774 [1378892319440940/10.50.20.66/-/1311ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/mobile/visit-template/get-template.action [321ms] RES:{"scode":"0"}
[长度：]5

curl -X GET 'https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/busiTypes/pickOptions' \
-H '0: 1' \
-H 'Content-Type: application/json' \
-H 'cookie: x-ienterprise-passport="f6UkNOgul7/JheR9kWclIZHitlESB2F5TFYyNgbQAcljxd+dF4VX6OmhIG+35J8laO6kLi3vMx5UwhK5+PHTPXc1h43cDRHALI+fMjqFLxJ+12qboMpjYou5koovj0P8ylN45s05GhCoiFz2QAjN/4ktsuCjMpaH";userId="1378892319440940";x-ienterprise-tenant=636704449298432' \
-H 'xsy-device: 1' \
-H 'xsy-user-id: 1378892319440940' \
-H 'xsy-tenant-id: 636704449298432'

2020-09-03 14:06:09,408 INFO 19774 [1378892319440940/10.50.20.66/-/1345ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] END> [GET]https://crm-citest.xiaoshouyi.com/rest/metadata/v2.0/xobjects/customEntity28__c/busiTypes/pickOptions [65ms] RES:{"code":"0","msg":null,"errorInfo":null}
2020-09-03 14:06:09,424 INFO 19774 [1378892319440940/10.50.20.66/-/1361ms GET /rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu] [145a616c-344c-4821-aa96-a74e159cf9d4] [1360ms] [GET]/rest/bff/v2/breeze/uimeta/entitycomponent?clientType=mobile&scenario=OpenCreationForm&formType=masterEntityCreation&entityOperation=OpenCreationForm&entityName=VisitRecord&entityBizType=defaultBusiType&visitModuleId=1091773901340709&objectId=1368790948429862&isApprovalForm=false&_vs=2007.0.4&appVersion=2007.0.4&appType=0&source=1&os=23&cache_key=1378892319440940&model=Android%20MuMu
