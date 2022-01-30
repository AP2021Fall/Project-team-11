package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Team {
    private static ArrayList<Team> teams = new ArrayList<>();
    private Map<String , User> chats = new HashMap<>();
    private ArrayList<Board> boards = new ArrayList<>();
    private String teamName;
    private int teamId;
    private Leader teamLeader;
    private Date creationDate;
    private HashMap <Member , Integer> scores= new HashMap <>();
    private static int idGenerator;
    private ArrayList <Task> allTasks = new ArrayList<>();

    public Team(String teamName, Leader teamLeader) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.teamId = ++idGenerator;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void addBoards(Board board) {
        this.boards.add(board);
    }

    public Map<String , User> getChats() {
        return chats;
    }

    public void addChats(String chat , User user) {
        chat = chats.size() + " " +chat;
        this.chats.put(chat, user);
    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public String getTeamName() {
        return teamName;
    }

    public Leader getTeamLeader() {
        return teamLeader;
    }

    public HashMap<Member, Integer> getTeamMembersScores(){
        sortTeamScores();
        return scores;
    }
    public ArrayList<Member> getMembers() {
        return new ArrayList<>(scores.keySet());
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getTeamNumber() {
        return teamId;
    }

    public void setTeamLeader(Leader teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void addMember(Member member){scores.put(member , 0);}

    public void deleteMember(Member member){scores.remove(member);}

    public static Team getTeamWithTeamName (String teamName){
        for (Team team : teams) {
            if(teamName.equals(team.teamName))
                return team;
        }
        return null;
    }

    public static Team getTeamWithId (int id){
        for (Team team : teams) {
            if(id == team.teamId)
                return team;
        }
        return null;
    }

    public ArrayList<Task> getAllTasks(){return allTasks;}

    public void sortTeamScores(){
        Map<Member, Integer> sortedMap =
                scores.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void addTask(Task task){
        allTasks.add(task);
    }

    public Member getMembersWithUsername(String username){
        for (Member member : scores.keySet()) {
            if(member.getUsername().equals(username))
                return member;
        }
        return null;
    }


    public void createBoard(){

    }

    public Task getTaskWithId(int id){
        for (Task task : allTasks) {
            if(task.getId() == id)
                return task;
        }
        return null;
    }

    public static void addTeam(Team team){
        teams.add(team);
    }

    public int getTeamId() {
        return teamId;
    }
}
