<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sinigang Social Full Version</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body{margin:0;font-family:Arial;background:#FFF6E5}
header{background:#2E7D32;color:#fff;padding:15px;text-align:center;font-size:22px}
section{max-width:800px;margin:auto;padding:15px}
.card{background:#fff;padding:15px;margin:10px 0;border-radius:10px;box-shadow:0 2px 6px rgba(0,0,0,.1)}
input,select,button,textarea{width:100%;padding:10px;margin:5px 0;border-radius:8px;border:1px solid #ccc}
button{background:#D32F2F;color:#fff;border:none;cursor:pointer}
button:hover{opacity:.9}
.alert{background:#ffebee;border-left:5px solid #D32F2F;padding:10px;border-radius:8px;margin:5px 0}
.badge{background:#2E7D32;color:#fff;padding:3px 8px;border-radius:12px;font-size:12px}
#messages{height:150px;overflow-y:auto;border:1px solid #ccc;padding:8px}
#storiesContainer img{width:60px;height:60px;border-radius:50%;margin:5px;cursor:pointer;border:2px solid #2E7D32}
#liveVideo{width:100%;height:300px;background:#000}
.hidden{display:none}
nav button{width:15%;padding:10px;margin:0;border-radius:8px;font-size:16px}
</style>
</head>
<body>

<header>🍲 SINIGANG SOCIAL FULL VERSION</header>

<!-- LOGIN / SIGNUP SECTION -->
<section id="loginSection">
  <div class="card">
    <div id="authNotice" class="alert hidden"></div>
    <h3 id="authTitle">Login</h3>
    <input id="fullName" placeholder="Full Name (Sign Up only)">
    <input id="email" placeholder="Email">
    <input id="password" type="password" placeholder="Password">
    <button id="authBtn" onclick="authAction()">Login</button>
    <p id="toggleText">Don't have an account? <a href="#" onclick="toggleAuth()">Sign Up</a></p>
  </div>
</section>

<!-- APP SECTION -->
<section id="appSection" class="hidden">

  <!-- NAVIGATION BAR -->
  <nav id="navbar" class="card" style="display:flex;justify-content:space-around;">
    <button onclick="showSection('home')">🏠 Home</button>
    <button onclick="showSection('feed')">📰 Feed</button>
    <button onclick="showSection('profile')">👤 Profile</button>
    <button onclick="showSection('account')">🔒 Account</button>
    <button onclick="showSection('settings')">⚙️ Settings</button>
    <button onclick="logout()">🚪 Logout</button>
  </nav>

  <!-- HOME SECTION -->
  <section id="homeSection" class="hidden">
    <div class="card">
      <h3>Welcome, <span id="userName"></span>!</h3>
      <p>This is your home page.</p>
    </div>
  </section>

  <!-- FEED SECTION -->
  <section id="feedSection" class="hidden">

    <!-- IP Tracker -->
    <div class="card">
      <h3>🌐 IP Tracker</h3>
      <div id="ipInfo"></div>
    </div>

    <!-- Stories -->
    <div class="card">
      <h3>📖 Stories</h3>
      <div id="storiesContainer"></div>
      <input id="storyInput" placeholder="Story text / image URL">
      <button onclick="addStory()">Add Story</button>
    </div>

    <!-- Live Video -->
    <div class="card">
      <h3>📹 Live Video</h3>
      <video id="liveVideo" autoplay muted playsinline></video>
      <button onclick="startLive()">Start Live</button>
      <button onclick="stopLive()">Stop Live</button>
    </div>

    <!-- Group Chat -->
    <div class="card">
      <h3>💬 Group Chat</h3>
      <select id="groupSelect"></select>
      <input id="newGroupInput" placeholder="New group name">
      <button onclick="createGroup()">Create Group</button>
      <div id="messages"></div>
      <input id="chatInput" placeholder="Type message">
      <button onclick="sendMessage()">Send</button>
      <div id="notifications"></div>
    </div>

  </section>

  <!-- PROFILE SECTION -->
  <section id="profileSection" class="hidden">
    <div class="card">
      <h3>Profile</h3>
      <p>Name: <span id="profileName"></span></p>
      <p>Email: <span id="profileEmail"></span></p>

      <!-- REPORT USER -->
      <div style="margin-top:10px;">
        <h4>Report User</h4>
        <input id="reportEmail" placeholder="User email to report">
        <textarea id="reportReason" placeholder="Reason for report"></textarea>
        <button onclick="reportUser()">Report</button>
        <div id="reportStatus"></div>
      </div>

      <div style="margin-top:10px;">
        <h4>Find Users</h4>
        <input id="searchEmail" placeholder="Search by email">
        <button onclick="searchUser()">Search</button>
        <div id="searchStatus"></div>
      </div>
    </div>
  </section>

  <!-- ACCOUNT SECTION -->
  <section id="accountSection" class="hidden">
    <div class="card">
      <h3>🔒 Account Settings</h3>

      <!-- Email Change -->
      <label>Change Email:</label>
      <input id="changeEmail" placeholder="New Email">
      <button onclick="changeEmail()">Update Email</button>

      <!-- Password Change -->
      <label>Change Password:</label>
      <input id="changePassword" type="password" placeholder="New Password">
      <button onclick="changePassword()">Update Password</button>

      <!-- Privacy Options -->
      <div style="margin-top:10px;">
        <h4>Privacy</h4>
        <label><input type="checkbox" id="accPrivate"> Private Account</label><br>
        <label><input type="checkbox" id="accHideStories"> Hide My Stories</label><br>
        <label><input type="checkbox" id="accHideChat"> Disable Chat</label><br>
        <button onclick="saveAccountPrivacy()">Save Privacy</button>
      </div>

      <!-- Delete Account -->
      <div style="margin-top:10px;">
        <h4>Danger Zone</h4>
        <button onclick="deleteAccount()" style="background:#B71C1C">Delete Account</button>
      </div>
    </div>
  </section>

  <!-- SETTINGS SECTION -->
  <section id="settingsSection" class="hidden">

    <!-- AI Security Logs -->
    <div class="card">
      <h3>🧠 AI Security Logs</h3>
      <div id="securityLog"></div>
    </div>

    <!-- Reports Log -->
    <div class="card">
      <h3>📋 Reports Log</h3>
      <div id="reportsLog"></div>
    </div>

    <div class="card">
      <h3>💾 Backup & Restore</h3>
      <button onclick="downloadBackup()">Download Backup</button>
      <textarea id="restoreInput" placeholder="Paste backup JSON to restore"></textarea>
      <button onclick="restoreBackup()">Restore Backup</button>
    </div>

  </section>

</section>

<script>
// ===== GLOBAL STATE =====
let users = JSON.parse(localStorage.getItem("users")) || {}
let currentUser = JSON.parse(localStorage.getItem("user")) || null
let sessionToken = localStorage.getItem("sessionToken") || null
let isLogin = true
let groups = JSON.parse(localStorage.getItem("groups")) || {"General":[]}
let security = JSON.parse(localStorage.getItem("security")) || []
let risk = JSON.parse(localStorage.getItem("risk")) || {}
let ipTracker = JSON.parse(localStorage.getItem("ipTracker")) || {}
let stories = JSON.parse(localStorage.getItem("stories")) || {}
let privacy = JSON.parse(localStorage.getItem("privacy")) || {}
let reports = JSON.parse(localStorage.getItem("reports")) || []
let liveStream = null

// ===== DOM ELEMENTS =====
const fullNameInput=document.getElementById("fullName")
const emailInput=document.getElementById("email")
const passwordInput=document.getElementById("password")
const authTitle=document.getElementById("authTitle")
const authBtn=document.getElementById("authBtn")
const authNotice=document.getElementById("authNotice")
const toggleText=document.getElementById("toggleText")
const loginSection=document.getElementById("loginSection")
const appSection=document.getElementById("appSection")
const userNameSpan=document.getElementById("userName")
const profileName=document.getElementById("profileName")
const profileEmail=document.getElementById("profileEmail")
const ipInfo=document.getElementById("ipInfo")
const storiesContainer=document.getElementById("storiesContainer")
const storyInput=document.getElementById("storyInput")
const liveVideo=document.getElementById("liveVideo")
const groupSelect=document.getElementById("groupSelect")
const newGroupInput=document.getElementById("newGroupInput")
const chatInput=document.getElementById("chatInput")
const messages=document.getElementById("messages")
const notifications=document.getElementById("notifications")
const securityLog=document.getElementById("securityLog")
const changeEmailInput=document.getElementById("changeEmail")
const changePasswordInput=document.getElementById("changePassword")
const accPrivate=document.getElementById("accPrivate")
const accHideStories=document.getElementById("accHideStories")
const accHideChat=document.getElementById("accHideChat")
const reportEmail=document.getElementById("reportEmail")
const reportReason=document.getElementById("reportReason")
const reportStatus=document.getElementById("reportStatus")
const reportsLog=document.getElementById("reportsLog")
const searchEmail=document.getElementById("searchEmail")
const searchStatus=document.getElementById("searchStatus")
const restoreInput=document.getElementById("restoreInput")
groupSelect.addEventListener("change",renderMessages)

// ===== AUTH API / MIGRATION =====
const AUTH_ENDPOINTS={
  signup:"/api/auth/signup",
  login:"/api/auth/login",
  session:"/api/auth/me",
  changeEmail:"/api/auth/change-email",
  changePassword:"/api/auth/change-password",
  deleteAccount:"/api/auth/delete-account"
}

function setAuthNotice(message){
  if(!message){
    authNotice.classList.add("hidden")
    authNotice.textContent=""
    return
  }
  authNotice.textContent=message
  authNotice.classList.remove("hidden")
}

function sanitizeUsers(userMap){
  const sanitized={}
  Object.entries(userMap||{}).forEach(([email,data])=>{
    const name=(data&&data.name)?data.name:email.split('@')[0]
    sanitized[email]={name}
  })
  return sanitized
}

function migrateLegacyAuthStorage(){
  const storedUsers=JSON.parse(localStorage.getItem("users")||"{}")
  const storedUser=JSON.parse(localStorage.getItem("user")||"null")
  const hasLegacyUsers=Object.values(storedUsers).some(u=>u&&typeof u==="object"&&"password" in u)
  const hasLegacyUser=storedUser&&typeof storedUser==="object"&&"password" in storedUser
  if(!hasLegacyUsers&&!hasLegacyUser) return

  localStorage.setItem("users",JSON.stringify(sanitizeUsers(storedUsers)))
  localStorage.removeItem("user")
  localStorage.removeItem("sessionToken")
  users=sanitizeUsers(storedUsers)
  currentUser=null
  sessionToken=null
  setAuthNotice("Security upgrade applied: legacy password data was removed. Please log in again.")
}

async function authRequest(url,payload={}){
  const headers={"Content-Type":"application/json"}
  if(sessionToken) headers.Authorization=`Bearer ${sessionToken}`
  const res=await fetch(url,{method:"POST",headers,credentials:"include",body:JSON.stringify(payload)})
  let data={}
  try{ data=await res.json() }catch{}
  if(!res.ok) throw new Error(data.error||data.message||"Authentication request failed")
  return data
}

function persistSession(data){
  const token=data.token||data.sessionToken||null
  const userData=data.user||data
  currentUser={
    email:userData.email,
    name:userData.name||userData.email?.split('@')[0]||"User"
  }
  users[currentUser.email]={name:currentUser.name}
  if(token){
    sessionToken=token
    localStorage.setItem("sessionToken",sessionToken)
  }else{
    sessionToken=null
    localStorage.removeItem("sessionToken")
  }
  localStorage.setItem("users",JSON.stringify(users))
  localStorage.setItem("user",JSON.stringify(currentUser))
}

// ===== AUTH SYSTEM =====
async function authAction(){
  const fullName=fullNameInput.value.trim()
  const email=emailInput.value.trim()
  const password=passwordInput.value.trim()
  if(!email||!password) return alert("Enter both email and password")
  try{
    if(isLogin){
      const data=await authRequest(AUTH_ENDPOINTS.login,{email,password})
      persistSession(data)
      showApp()
    } else {
      if(!fullName){ alert("Enter your full name"); return }
      const data=await authRequest(AUTH_ENDPOINTS.signup,{name:fullName,email,password})
      persistSession(data)
      showApp()
    }
  }catch(err){
    alert(err.message||"Unable to authenticate")
  }
}
function toggleAuth(){
  isLogin=!isLogin
  authTitle.textContent=isLogin?"Login":"Sign Up"
  authBtn.textContent=isLogin?"Login":"Sign Up"
  toggleText.innerHTML=isLogin?`Don't have an account? <a href="#" onclick="toggleAuth()">Sign Up</a>`:`Already have an account? <a href="#" onclick="toggleAuth()">Login</a>`
  fullNameInput.style.display=isLogin?"none":"block"
}
function showApp(){
  loginSection.classList.add("hidden")
  appSection.classList.remove("hidden")
  userNameSpan.textContent=currentUser.name
  profileName.textContent=currentUser.name
  profileEmail.textContent=currentUser.email
  fullNameInput.value=""
  emailInput.value=""
  passwordInput.value=""
  trackIP()
  loadGroups()
  renderStories()
  loadAccountUI()
  renderSecurity()
  renderReports()
  showSection('home')
}
function logout(){
  currentUser=null
  sessionToken=null
  localStorage.removeItem("user")
  localStorage.removeItem("sessionToken")
  appSection.classList.add("hidden")
  loginSection.classList.remove("hidden")
}

// ===== NAVIGATION =====
const sectionsList = ['homeSection','feedSection','profileSection','accountSection','settingsSection']
function showSection(sectionId){
  sectionsList.forEach(id=>document.getElementById(id).classList.add('hidden'))
  const el=document.getElementById(sectionId+'Section')
  if(el) el.classList.remove('hidden')
}

// ===== IP TRACKER =====
async function getIP(){try{let r=await fetch("https://api.ipify.org?format=json");let d=await r.json();return d.ip}catch{return "unknown"}}
async function trackIP(){
  let ip=await getIP()
  let u=currentUser.email
  if(!ipTracker[u]) ipTracker[u]=[]
  if(!ipTracker[u].includes(ip)){ ipTracker[u].push(ip); aiDetect("New IP detected") }
  localStorage.setItem("ipTracker",JSON.stringify(ipTracker))
  ipInfo.innerHTML=`<b>Current IP:</b> ${ip}<br><b>Known IPs:</b> ${ipTracker[u].length}`
  if(ipTracker[u].length>=4) aiDetect("Multiple IP hopping")
}

// ===== STORIES =====
function addStory(){
  let text=storyInput.value.trim(); if(!text) return
  let u=currentUser.email; if(!stories[u]) stories[u]=[]
  stories[u].push({text,time:new Date().toLocaleString()})
  localStorage.setItem("stories",JSON.stringify(stories))
  storyInput.value=""; renderStories()
}
function renderStories(){
  storiesContainer.innerHTML=""
  for(let user in stories){
    if(privacy[user]?.hideStories) continue
    let latest=stories[user][stories[user].length-1]; if(!latest) continue
    let img=document.createElement("img"); img.title=user+": "+latest.text; img.src="https://via.placeholder.com/60?text=Story"
    storiesContainer.appendChild(img)
  }
}

// ===== LIVE VIDEO =====
async function startLive(){ try{ liveStream=await navigator.mediaDevices.getUserMedia({video:true,audio:true}); liveVideo.srcObject=liveStream }catch(e){alert("Cannot access camera/microphone")} }
function stopLive(){ if(liveStream) liveStream.getTracks().forEach(t=>t.stop()) }

// ===== GROUP CHAT =====
function loadGroups(){
  groupSelect.innerHTML=""
  Object.keys(groups).forEach(g=>{ let o=document.createElement("option"); o.textContent=g; groupSelect.appendChild(o) })
  renderMessages()
}
function createGroup(){
  const groupName=newGroupInput.value.trim()
  if(!groupName) return alert("Enter a group name")
  if(groups[groupName]) return alert("Group already exists")
  groups[groupName]=[]
  localStorage.setItem("groups",JSON.stringify(groups))
  newGroupInput.value=""
  loadGroups()
  groupSelect.value=groupName
  notify(`Created group: ${groupName}`)
}
function sendMessage(){
  if(privacy[currentUser.email]?.hideChat||privacy[currentUser.email]?.private) return alert("Chat disabled or private account")
  let g=groupSelect.value
  let text=chatInput.value.trim(); if(!text) return
  groups[g].push({user:currentUser.email,text,time:new Date().toLocaleTimeString()})
  localStorage.setItem("groups",JSON.stringify(groups))
  chatInput.value=""; renderMessages(); notify(`${currentUser.email} sent a message`)
}
function renderMessages(){
  let g=groupSelect.value; messages.innerHTML=""
  groups[g].forEach(m=>{ messages.innerHTML+=`<div><b>${m.user}</b>: ${m.text} <small>${m.time}</small></div>` })
  messages.scrollTop=messages.scrollHeight
}
function notify(text){ let d=document.createElement("div"); d.className="badge"; d.textContent="🔔 "+text; notifications.prepend(d); setTimeout(()=>d.remove(),4000) }

// ===== PRIVACY / ACCOUNT =====
function loadAccountUI(){
  let p=privacy[currentUser.email]||{private:false,hideStories:false,hideChat:false}
  accPrivate.checked=p.private; accHideStories.checked=p.hideStories; accHideChat.checked=p.hideChat
}
function saveAccountPrivacy(){ privacy[currentUser.email]={private:accPrivate.checked,hideStories:accHideStories.checked,hideChat:accHideChat.checked}; localStorage.setItem("privacy",JSON.stringify(privacy)); alert("Privacy saved!"); renderStories() }
function changeEmail(){
  let newEmail=changeEmailInput.value.trim(); if(!newEmail) return alert("Enter a valid email")
  if(users[newEmail]) return alert("Email already exists")
  authRequest(AUTH_ENDPOINTS.changeEmail,{newEmail}).then(()=>{
    users[newEmail]=users[currentUser.email]?users[currentUser.email]:{name:currentUser.name}
    delete users[currentUser.email]
    localStorage.setItem("users",JSON.stringify(users))
    if(privacy[currentUser.email]) privacy[newEmail]=privacy[currentUser.email]
    if(stories[currentUser.email]) stories[newEmail]=stories[currentUser.email]
    if(ipTracker[currentUser.email]) ipTracker[newEmail]=ipTracker[currentUser.email]
    if(risk[currentUser.email]) risk[newEmail]=risk[currentUser.email]
    delete privacy[currentUser.email]; delete stories[currentUser.email]; delete ipTracker[currentUser.email]; delete risk[currentUser.email]
    currentUser.email=newEmail
    localStorage.setItem("user",JSON.stringify(currentUser))
    localStorage.setItem("privacy",JSON.stringify(privacy))
    localStorage.setItem("stories",JSON.stringify(stories))
    localStorage.setItem("ipTracker",JSON.stringify(ipTracker))
    localStorage.setItem("risk",JSON.stringify(risk))
    updateUserUI(); loadAccountUI(); alert("Email updated successfully!"); changeEmailInput.value=""
  }).catch(err=>alert(err.message||"Could not update email"))
}
function changePassword(){
  let newPassword=changePasswordInput.value.trim()
  if(!newPassword) return alert("Enter a valid password")
  authRequest(AUTH_ENDPOINTS.changePassword,{newPassword}).then(()=>{
    alert("Password updated!")
    changePasswordInput.value=""
  }).catch(err=>alert(err.message||"Could not update password"))
}
function deleteAccount(){
  if(!confirm("Are you sure?")) return
  authRequest(AUTH_ENDPOINTS.deleteAccount,{}).then(()=>{
    delete privacy[currentUser.email]; delete stories[currentUser.email]; delete ipTracker[currentUser.email]; delete risk[currentUser.email]; delete users[currentUser.email]
    localStorage.removeItem("user")
    localStorage.removeItem("sessionToken")
    localStorage.setItem("users",JSON.stringify(users))
    currentUser=null
    sessionToken=null
    alert("Account deleted!")
    location.reload()
  }).catch(err=>alert(err.message||"Could not delete account"))
}
function updateUserUI(){ document.getElementById('userName').textContent=currentUser.name; document.getElementById('profileName').textContent=currentUser.name; document.getElementById('profileEmail').textContent=currentUser.email }

// ===== AI SECURITY =====
function aiDetect(reason){ let u=currentUser.email; if(!risk[u]) risk[u]=0; let score={"New IP detected":2,"Multiple IP hopping":3}[reason]||1; risk[u]+=score; security.unshift({user:u,reason,risk:risk[u],time:new Date().toLocaleString()}); localStorage.setItem("security",JSON.stringify(security)); localStorage.setItem("risk",JSON.stringify(risk)); renderSecurity() }
function renderSecurity(){ securityLog.innerHTML=""; security.forEach(s=>{ securityLog.innerHTML+=`<div class="alert">⚠ ${s.reason}<br>User: ${s.user}<br>Risk: ${s.risk}<br>Time: ${s.time}</div>` }) }

// ===== REPORT USER =====
function reportUser(){
  const emailR=reportEmail.value.trim(), reason=reportReason.value.trim(); if(!emailR||!reason){ reportStatus.textContent="Enter email and reason"; return }
  reports.push({reportedBy:currentUser.email,email:emailR,reason,time:new Date().toLocaleString()})
  localStorage.setItem("reports",JSON.stringify(reports))
  reportStatus.textContent="Reported successfully!"
  reportEmail.value=""; reportReason.value=""
  renderReports()
}
function renderReports(){ reportsLog.innerHTML=""; reports.forEach(r=>{ reportsLog.innerHTML+=`<div class="alert">Reported by: ${r.reportedBy}<br>Email: ${r.email}<br>Reason: ${r.reason}<br>Time: ${r.time}</div>` }) }

// ===== SEARCH USERS =====
function searchUser(){
  const email=searchEmail.value.trim()
  if(!email){
    searchStatus.textContent="Enter an email to search"
    return
  }
  if(users[email]){
    const name=users[email].name||"Unknown"
    const accountPrivacy=privacy[email]?.private ? "Private" : "Public"
    searchStatus.innerHTML=`Found: <b>${name}</b> (${email}) - ${accountPrivacy} account`
  }else{
    searchStatus.textContent="User not found"
  }
}

// ===== BACKUP / RESTORE =====
function downloadBackup(){
  const backup={users,groups,security,risk,ipTracker,stories,privacy,reports,user:currentUser}
  const blob=new Blob([JSON.stringify(backup,null,2)],{type:"application/json"})
  const link=document.createElement("a")
  link.href=URL.createObjectURL(blob)
  link.download="sinigang-social-backup.json"
  link.click()
  URL.revokeObjectURL(link.href)
}
function restoreBackup(){
  try{
    const data=JSON.parse(restoreInput.value)
    users=sanitizeUsers(data.users||{})
    groups=data.groups||{"General":[]}
    security=data.security||[]
    risk=data.risk||{}
    ipTracker=data.ipTracker||{}
    stories=data.stories||{}
    privacy=data.privacy||{}
    reports=data.reports||[]
    currentUser=data.user?{email:data.user.email,name:data.user.name||data.user.email?.split('@')[0]}:currentUser
    sessionToken=data.sessionToken||null

    localStorage.setItem("users",JSON.stringify(users))
    localStorage.setItem("groups",JSON.stringify(groups))
    localStorage.setItem("security",JSON.stringify(security))
    localStorage.setItem("risk",JSON.stringify(risk))
    localStorage.setItem("ipTracker",JSON.stringify(ipTracker))
    localStorage.setItem("stories",JSON.stringify(stories))
    localStorage.setItem("privacy",JSON.stringify(privacy))
    localStorage.setItem("reports",JSON.stringify(reports))
    if(currentUser) localStorage.setItem("user",JSON.stringify(currentUser))
    if(sessionToken) localStorage.setItem("sessionToken",sessionToken)
    else localStorage.removeItem("sessionToken")

    restoreInput.value=""
    alert("Backup restored successfully")
    if(currentUser) showApp()
  }catch(e){
    alert("Invalid backup JSON")
  }
}

// ===== INITIALIZE =====
migrateLegacyAuthStorage()
if(currentUser){
  authRequest(AUTH_ENDPOINTS.session,{}).then(data=>{
    persistSession(data)
    showApp()
  }).catch(()=>{
    logout()
    setAuthNotice("Your session expired. Please log in again.")
  })
}
toggleAuth() // hide full name input initially
</script>

</body>
</html>
