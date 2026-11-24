-- Bootstrap schema for a fresh ZYRO Supabase project.
-- Existing production projects already have these tables; every statement is idempotent.

create extension if not exists pgcrypto;

create table if not exists public.zyro_site_config (
  id text primary key
    check (id = 'main'),
  data jsonb not null,
  updated_at timestamptz not null default now()
);

create table if not exists public.zyro_registrations (
  id uuid primary key default gen_random_uuid(),
  created_at timestamptz not null default now(),
  zalo_name text not null,
  duration text not null,
  gender text not null,
  position text not null,
  level text not null,
  goal text not null,
  status text not null default 'new'
    check (status in ('new', 'approved', 'rejected'))
);

create index if not exists zyro_registrations_created_at_idx
  on public.zyro_registrations (created_at desc);

create index if not exists zyro_registrations_status_created_at_idx
  on public.zyro_registrations (status, created_at desc);

create index if not exists zyro_registrations_zalo_name_idx
  on public.zyro_registrations (zalo_name);

alter table public.zyro_site_config enable row level security;
alter table public.zyro_registrations enable row level security;

revoke all on table public.zyro_site_config from public, anon, authenticated;
revoke all on table public.zyro_registrations from public, anon, authenticated;

grant select, insert, update on table public.zyro_site_config to service_role;
grant select, insert, update, delete on table public.zyro_registrations to service_role;

insert into public.zyro_site_config (id, data, updated_at)
values (
  'main',
  $json$
  {
    "hero": {
      "titleLine1": "Chơi vui.",
      "titleLine2": "Tiến bộ.",
      "lead": "Một sân chơi lâu dài cho người mới và những bạn muốn đánh bóng trong không khí thoải mái, hòa đồng, không đặt nặng thắng — thua."
    },
    "schedule": [
      { "id": "sat", "day": "T7", "start": "18:30", "end": "21:30" },
      { "id": "sun", "day": "CN", "start": "18:30", "end": "21:30" }
    ],
    "principles": [
      { "id": "newbie", "title": "Newbie-first", "body": "Người mới được chào đón và có không gian để tiến bộ." },
      { "id": "friendly", "title": "Không hơn thua", "body": "Đồng đội đánh lỗi thì góp ý, không cáu gắt hay thể hiện." },
      { "id": "longterm", "title": "Chơi lâu dài", "body": "Ưu tiên những bạn muốn sinh hoạt và giao lưu cùng nhóm thường xuyên." }
    ],
    "signup": {
      "title": "4 câu. Khoảng 1 phút.",
      "intro": "Tụi mình dùng thông tin này để hiểu bạn hơn trước khi duyệt vào nhóm. Không phải phỏng vấn, cứ trả lời đúng với bạn là được.",
      "privacyNote": "Thông tin chỉ dùng cho việc duyệt thành viên ZYRO.",
      "successTitle": "Hẹn gặp bạn trên sân.",
      "successMessage": "Bước cuối: chủ động nhắn Zalo cho một trong các admin và ghi “Mình đã hoàn thành form” để tụi mình check nhanh nhé."
    },
    "contacts": [
      { "id": "nguyen", "name": "Anh Nguyễn", "role": "Phó nhóm", "phone": "0836000190" },
      { "id": "long", "name": "Long", "role": "Phó nhóm", "phone": "0364964897" },
      { "id": "contact_46747731", "name": "Chị Trúc", "role": "Phó nhóm", "phone": "0382970052" }
    ],
    "formOptions": {
      "duration": [
        { "id": "long", "label": "Lâu dài", "description": "Muốn sinh hoạt cùng nhóm thường xuyên" },
        { "id": "unsure", "label": "Muốn trải nghiệm trước", "description": "Chưa xác định, muốn thử vài buổi" },
        { "id": "short", "label": "Ngắn hạn", "description": "Chủ yếu tham gia giao lưu một vài buổi" }
      ],
      "gender": [
        { "id": "male", "label": "Nam" },
        { "id": "female", "label": "Nữ" }
      ],
      "position": [
        { "id": "attacker", "label": "Công" },
        { "id": "defender", "label": "Thủ" },
        { "id": "setter", "label": "Chuyền 2" },
        { "id": "allrounder", "label": "Toàn diện" }
      ],
      "level": [
        { "id": "newbie", "label": "Người mới" },
        { "id": "intermediate", "label": "Trung bình" },
        { "id": "good", "label": "Tốt" }
      ]
    },
    "emailTemplates": {
      "design": {
        "logoUrl": "https://zyro-volleyball-club.onrender.com/assets/zyro-logo.webp",
        "brandName": "ZYRO VOLLEYBALL CLUB",
        "tagline": "",
        "headerColor": "#0b2d5f",
        "accentColor": "#d71e32",
        "footerText": "Email tự động từ ZYRO Volleyball Club. Vui lòng không trả lời email này."
      },
      "approved": {
        "subject": "ZYRO | Đăng ký của bạn đã được chấp nhận!",
        "preheader": "Chào mừng bạn đến với ZYRO Volleyball Club.",
        "title": "Bạn đã được ZYRO chấp nhận!",
        "showProfile": true,
        "bodyHtml": "<p>Chào <strong>{{zalo_name}}</strong>! 🏐</p><p>Ban quản trị ZYRO đã xem xét và chấp nhận đơn đăng ký của bạn.</p><p>Yêu cầu tham gia nhóm Zalo hiện đang chờ phó nhóm phê duyệt. Bạn vui lòng chờ thông báo nhé!</p><p>Hẹn gặp bạn trên sân!</p>"
      },
      "rejected": {
        "subject": "ZYRO | Phản hồi đăng ký thành viên",
        "preheader": "Cảm ơn bạn đã quan tâm đến ZYRO Volleyball Club.",
        "title": "Cảm ơn bạn đã quan tâm đến ZYRO",
        "showProfile": true,
        "bodyHtml": "<p>Chào <strong>{{zalo_name}}</strong>,</p><p>Sau khi xem xét thông tin đăng ký và mong muốn tham gia của bạn, Ban quản trị rất tiếc hiện tại chưa thể chấp nhận đăng ký.</p><p><strong>Lý do:</strong> {{reason}}</p><p>Cảm ơn bạn đã dành thời gian tìm hiểu và đăng ký tham gia ZYRO. Chúc bạn luôn có những trận đấu vui vẻ!</p>"
      }
    }
  }
  $json$::jsonb,
  '2026-11-03T07:07:04.992+00:00'::timestamptz
)
on conflict (id) do nothing;
